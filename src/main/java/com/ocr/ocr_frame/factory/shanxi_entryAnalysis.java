package com.ocr.ocr_frame.factory;

import com.ocr.ocr_frame.factory.Interface.EntryShape;
import com.ocr.ocr_frame.factory.Interface.Parser;
import com.ocr.ocr_frame.mapping.Entry;
import org.springframework.beans.factory.annotation.Value;
import sun.security.krb5.internal.tools.Klist;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * author:pan le
 * Date:2019/2/14
 * Time:17:02
 */
public class shanxi_entryAnalysis implements EntryShape {

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

    private List<Entry> entries = new ArrayList<>();
    private List<List<Entry>> entryList = new ArrayList<>();



    @Override
    public List<Entry> entryAnalysis(String content, Parser parser) {
        Entry entry = new Entry();
        List<String> cons = new ArrayList<>();
        for (String str : content.split("\n")) {
            if (batchPattern.matcher(str).find()) {
                entry = Entry.builder().title(str).content(cons).build();
                cons.clear();
            } else {
                cons.add(str);
            }
            entries.add(entry);
        }
        entryList.add(entries);
        return entries;
    }
}
