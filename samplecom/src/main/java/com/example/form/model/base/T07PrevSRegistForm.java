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
public class T07PrevSRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(T07PrevRegistForm.class);

    /** 前世登録フォームのリスト */
    @Valid
    private List<T07PrevRegistForm> t07PrevGrid;

    /**
     * @return 前世登録フォームのリスト
     */
    public List<T07PrevRegistForm> getT07PrevGrid() {
        return t07PrevGrid;
    }

    /**
     * @param p 前世登録フォームのリスト
     */
    public void setT07PrevGrid(final List<T07PrevRegistForm> p) {
        this.t07PrevGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        if (this.t07PrevGrid != null) {
            for (int i = 0; i < this.t07PrevGrid.size(); i++) {
                T07PrevRegistForm form = this.t07PrevGrid.get(i);
                if (form != null) {
                    Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                    form.validate(gridErrors, baseProcess);
                    BaseProcess.copyGridErrors(errors, "T07PrevGrid", i, gridErrors);
                }
            }
        }
    }

}
