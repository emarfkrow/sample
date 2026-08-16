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
public class T06PrevDetSRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(T06PrevDetRegistForm.class);

    /** 前世明細登録フォームのリスト */
    @Valid
    private List<T06PrevDetRegistForm> t06PrevDetGrid;

    /**
     * @return 前世明細登録フォームのリスト
     */
    public List<T06PrevDetRegistForm> getT06PrevDetGrid() {
        return t06PrevDetGrid;
    }

    /**
     * @param p 前世明細登録フォームのリスト
     */
    public void setT06PrevDetGrid(final List<T06PrevDetRegistForm> p) {
        this.t06PrevDetGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        if (this.t06PrevDetGrid != null) {
            for (int i = 0; i < this.t06PrevDetGrid.size(); i++) {
                T06PrevDetRegistForm form = this.t06PrevDetGrid.get(i);
                if (form != null) {
                    Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                    form.validate(gridErrors, baseProcess);
                    BaseProcess.copyGridErrors(errors, "T06PrevDetGrid", i, gridErrors);
                }
            }
        }
    }

}
