package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 前世一覧登録フォーム
 *
 * @author emarfkrow
 */
public class T06PrevSRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(T06PrevRegistForm.class);

    /** 前世登録フォームのリスト */
    @Valid
    private List<T06PrevRegistForm> t06PrevGrid;

    /**
     * @return 前世登録フォームのリスト
     */
    public List<T06PrevRegistForm> getT06PrevGrid() {
        return t06PrevGrid;
    }

    /**
     * @param p 前世登録フォームのリスト
     */
    public void setT06PrevGrid(final List<T06PrevRegistForm> p) {
        this.t06PrevGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        if (this.t06PrevGrid != null) {
            for (int i = 0; i < this.t06PrevGrid.size(); i++) {
                T06PrevRegistForm form = this.t06PrevGrid.get(i);
                if (form != null) {
                    Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                    form.validate(gridErrors, baseProcess);
                    BaseProcess.copyGridErrors(errors, "T06PrevGrid", i, gridErrors);
                }
            }
        }
    }

}
