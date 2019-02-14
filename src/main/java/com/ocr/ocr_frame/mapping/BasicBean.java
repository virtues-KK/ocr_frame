package com.ocr.ocr_frame.mapping;

import lombok.Data;

import javax.persistence.ElementCollection;
import javax.persistence.MappedSuperclass;
import java.util.ArrayList;
import java.util.List;

/**
 * author:pan le
 * Date:2019/2/14
 * Time:10:15
 * 招生信息基本类
 */

@MappedSuperclass
@Data
public class BasicBean {
    //招生人数错误
    @ElementCollection
    protected List<String> errors = new ArrayList<>();

    // 错误数量
    protected Integer errorCount;

    protected Integer collegeEnrollNum;

    protected Integer majorEnrollNum;

    protected String collegeCode;

    protected String collegeName;

    protected String majorCode;

    protected String majorName;

}
