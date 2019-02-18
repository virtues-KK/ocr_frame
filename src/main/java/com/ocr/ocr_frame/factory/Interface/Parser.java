package com.ocr.ocr_frame.factory.Interface;

import java.util.regex.Pattern;

public interface Parser {

    Pattern getReg();
    Parser getNext(String content);
}
