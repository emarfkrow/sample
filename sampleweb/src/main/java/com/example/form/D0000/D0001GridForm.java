package com.example.form.D0000;

import java.util.Map;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 検索画面グリッドフォーム
 * @author toshiyuki
 *
 */
public class D0001GridForm implements IForm {

    /***/
    @NotBlank
    private String sosenId;

    /***/
    @NotBlank
    private String oyaSn;

    /***/
    @NotBlank
    private String entitySn;

    /***/
    @NotBlank
    @Pattern(regexp = "[0-9]*")
    private String entityMei;

    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        // TODO 自動生成されたメソッド・スタブ

    }

}
