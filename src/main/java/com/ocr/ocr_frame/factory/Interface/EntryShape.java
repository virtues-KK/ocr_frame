package com.ocr.ocr_frame.factory.Interface;

import com.ocr.ocr_frame.mapping.Entry;

import java.util.List;

public interface EntryShape {
    List<List<Entry>> entryAnalysis(String content,Parser parser);
}
