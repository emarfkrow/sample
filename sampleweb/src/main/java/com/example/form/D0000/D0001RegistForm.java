package com.example.form.D0000;

import java.util.List;
import java.util.Map;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 検索画面登録フォーム
 * @author toshiyuki
 *
 */
public class D0001RegistForm implements IForm {

    // /***/
    // @NotBlank
    // private String sosenId;
    //
    // /***/
    // @NotBlank
    // private String oyaSn;
    //
    // /***/
    // @NotBlank
    // @Pattern(regexp = "[0-9]*")
    // private String entitySn;
    //
    // /***/
    // @NotBlank
    // private String entityMei;

    /**
     *
     */
    @Valid
    private List<D0001GridForm> d0001Grid;

    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        // TODO 自動生成されたメソッド・スタブ

    }

}
