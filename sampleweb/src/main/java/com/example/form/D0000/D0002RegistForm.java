package com.example.form.D0000;

import java.util.Map;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 詳細画面登録フォーム
 * @author toshiyuki
 *
 */
public class D0002RegistForm implements IForm {

    /***/
    @NotBlank
    private String sosenId;

    /***/
    @NotBlank
    private String oyaSn;

    /***/
    @NotBlank
    @Pattern(regexp = "[0-9]*")
    private String entitySn;

    /***/
    @NotBlank
    private String entityMei;

    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        // TODO 自動生成されたメソッド・スタブ

    }

    /**
     * @return sosenId
     */
    public String getSosenId() {
        return sosenId;
    }

    /**
     * @param p セットする sosenId
     */
    public void setSosenId(final String p) {
        this.sosenId = p;
    }

    /**
     * @return oyaSn
     */
    public String getOyaSn() {
        return oyaSn;
    }

    /**
     * @param p セットする oyaSn
     */
    public void setOyaSn(final String p) {
        this.oyaSn = p;
    }

    /**
     * @return entitySn
     */
    public String getEntitySn() {
        return entitySn;
    }

    /**
     * @param p セットする entitySn
     */
    public void setEntitySn(final String p) {
        this.entitySn = p;
    }

    /**
     * @return entityMei
     */
    public String getEntityMei() {
        return entityMei;
    }

    /**
     * @param p セットする entityMei
     */
    public void setEntityMei(final String p) {
        this.entityMei = p;
    }

}
