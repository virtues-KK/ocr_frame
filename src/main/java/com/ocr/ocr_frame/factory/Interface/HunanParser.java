package com.ocr.ocr_frame.factory.Interface;

/**
 * author:pan le
 * Date:2019/2/14
 * Time:17:38
 */
public class HunanParser  implements  Parser{

    @Override
    public Parser tNext() {
        return College;
    }
}
