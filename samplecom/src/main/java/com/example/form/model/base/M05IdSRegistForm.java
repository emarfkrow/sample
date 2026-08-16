package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * IDマスタ一覧登録フォーム
 *
 * @author emarfkrow
 */
public class M05IdSRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(M05IdRegistForm.class);

    /** IDマスタ登録フォームのリスト */
    @Valid
    private List<M05IdRegistForm> m05IdGrid;

    /**
     * @return IDマスタ登録フォームのリスト
     */
    public List<M05IdRegistForm> getM05IdGrid() {
        return m05IdGrid;
    }

    /**
     * @param p IDマスタ登録フォームのリスト
     */
    public void setM05IdGrid(final List<M05IdRegistForm> p) {
        this.m05IdGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        if (this.m05IdGrid != null) {
            for (int i = 0; i < this.m05IdGrid.size(); i++) {
                M05IdRegistForm form = this.m05IdGrid.get(i);
                if (form != null) {
                    Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                    form.validate(gridErrors, baseProcess);
                    BaseProcess.copyGridErrors(errors, "M05IdGrid", i, gridErrors);
                }
            }
        }
    }

}
