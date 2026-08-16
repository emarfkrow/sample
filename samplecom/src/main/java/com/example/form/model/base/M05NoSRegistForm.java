package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * NOマスタ一覧登録フォーム
 *
 * @author emarfkrow
 */
public class M05NoSRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(M05NoRegistForm.class);

    /** NOマスタ登録フォームのリスト */
    @Valid
    private List<M05NoRegistForm> m05NoGrid;

    /**
     * @return NOマスタ登録フォームのリスト
     */
    public List<M05NoRegistForm> getM05NoGrid() {
        return m05NoGrid;
    }

    /**
     * @param p NOマスタ登録フォームのリスト
     */
    public void setM05NoGrid(final List<M05NoRegistForm> p) {
        this.m05NoGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        if (this.m05NoGrid != null) {
            for (int i = 0; i < this.m05NoGrid.size(); i++) {
                M05NoRegistForm form = this.m05NoGrid.get(i);
                if (form != null) {
                    Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                    form.validate(gridErrors, baseProcess);
                    BaseProcess.copyGridErrors(errors, "M05NoGrid", i, gridErrors);
                }
            }
        }
    }

}
