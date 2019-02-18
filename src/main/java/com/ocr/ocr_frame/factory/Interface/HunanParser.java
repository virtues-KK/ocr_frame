package com.ocr.ocr_frame.factory.Interface;

import com.ocr.ocr_frame.mapping.Entry;
import org.springframework.beans.factory.annotation.Value;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 * author:pan le
 * Date:2019/2/14
 * Time:17:38
 */
public class HunanParser implements Parser{

    @Value("${}")
    private String batchRegular;
    private Pattern batchPattern = Pattern.compile(batchRegular);

    @Value("${}")
    private String academicRegular;
    private Pattern academicPattern = Pattern.compile(academicRegular);

    @Value("${}")
    private String collegeRegular;
    private Pattern collegePattern = Pattern.compile(collegeRegular);

    @Value("${}")
    private String majorRegular;
    private Pattern majorPattern = Pattern.compile(majorRegular);

    @Override
    public Pattern getReg() {
        // 一次性 不重复 有顺序
        ArrayList<Pattern> patterns = (ArrayList<Pattern>) Arrays.asList(batchPattern, academicPattern, collegePattern, majorPattern);
        Pattern reg = patterns.get(0);
        patterns.remove(0);
        return reg;
    }

    @Override
    public Parser getNext(String content) {
        return null;
    }
}
