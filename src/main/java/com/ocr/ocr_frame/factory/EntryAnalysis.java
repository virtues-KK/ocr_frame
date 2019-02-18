package com.ocr.ocr_frame.factory;

import com.ocr.ocr_frame.factory.Interface.EntryShape;
import com.ocr.ocr_frame.factory.Interface.Parser;
import com.ocr.ocr_frame.mapping.Entry;
import org.springframework.beans.factory.annotation.Value;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import static java.lang.String.join;

/**
 * author:pan le
 * Date:2019/2/14
 * Time:17:02
 */
public class EntryAnalysis implements EntryShape {

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
    public List<List<Entry>> entryAnalysis(String content, Parser parser) {
        Entry entry = new Entry();
        List<String> cons = new ArrayList<>();
        for (String str : content.split("\n")) {
            if (parser.getReg().matcher(str).find()) {
                entry = Entry.builder().title(str).content(cons).build();
                cons.clear();
            } else {
                cons.add(str);
            }
            //出口
            if (parser.getReg() == null){
                return null;
            }
            entries.add(entry);
        }
        // list<String> --> String
        for (Entry entry1 : entries) {
            List<String> contents = entry1.getContent();
            String join = join("\n", contents);
            this.entryAnalysis(join,parser);
        }
        entryList.add(entries);
        return entryList;
    }
}
