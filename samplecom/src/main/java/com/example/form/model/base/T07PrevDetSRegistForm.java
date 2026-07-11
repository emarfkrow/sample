package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 前世明細一覧登録フォーム
 *
 * @author emarfkrow
 */
public class T07PrevDetSRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(T07PrevDetRegistForm.class);

    /** 前世明細登録フォームのリスト */
    @Valid
    private List<T07PrevDetRegistForm> t07PrevDetGrid;

    /**
     * @return 前世明細登録フォームのリスト
     */
    public List<T07PrevDetRegistForm> getT07PrevDetGrid() {
        return t07PrevDetGrid;
    }

    /**
     * @param p 前世明細登録フォームのリスト
     */
    public void setT07PrevDetGrid(final List<T07PrevDetRegistForm> p) {
        this.t07PrevDetGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        if (this.t07PrevDetGrid != null) {
            for (int i = 0; i < this.t07PrevDetGrid.size(); i++) {
                T07PrevDetRegistForm form = this.t07PrevDetGrid.get(i);
                if (form != null) {
                    Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                    form.validate(gridErrors, baseProcess);
                    BaseProcess.copyGridErrors(errors, "T07PrevDetGrid", i, gridErrors);
                }
            }
        }
    }

}
