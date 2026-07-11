package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 変換先一覧登録フォーム
 *
 * @author emarfkrow
 */
public class T13DestSRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(T13DestRegistForm.class);

    /** 変換先登録フォームのリスト */
    @Valid
    private List<T13DestRegistForm> t13DestGrid;

    /**
     * @return 変換先登録フォームのリスト
     */
    public List<T13DestRegistForm> getT13DestGrid() {
        return t13DestGrid;
    }

    /**
     * @param p 変換先登録フォームのリスト
     */
    public void setT13DestGrid(final List<T13DestRegistForm> p) {
        this.t13DestGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        if (this.t13DestGrid != null) {
            for (int i = 0; i < this.t13DestGrid.size(); i++) {
                T13DestRegistForm form = this.t13DestGrid.get(i);
                if (form != null) {
                    Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                    form.validate(gridErrors, baseProcess);
                    BaseProcess.copyGridErrors(errors, "T13DestGrid", i, gridErrors);
                }
            }
        }
    }

}
