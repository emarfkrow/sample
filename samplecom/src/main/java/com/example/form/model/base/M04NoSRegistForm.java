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
public class M04NoSRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(M04NoRegistForm.class);

    /** NOマスタ登録フォームのリスト */
    @Valid
    private List<M04NoRegistForm> m04NoGrid;

    /**
     * @return NOマスタ登録フォームのリスト
     */
    public List<M04NoRegistForm> getM04NoGrid() {
        return m04NoGrid;
    }

    /**
     * @param p NOマスタ登録フォームのリスト
     */
    public void setM04NoGrid(final List<M04NoRegistForm> p) {
        this.m04NoGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        if (this.m04NoGrid != null) {
            for (int i = 0; i < this.m04NoGrid.size(); i++) {
                M04NoRegistForm form = this.m04NoGrid.get(i);
                if (form != null) {
                    Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                    form.validate(gridErrors, baseProcess);
                    BaseProcess.copyGridErrors(errors, "M04NoGrid", i, gridErrors);
                }
            }
        }
    }

}
