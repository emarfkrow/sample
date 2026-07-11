package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * エンティティ一覧登録フォーム
 *
 * @author emarfkrow
 */
public class T00EntitySRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(T00EntityRegistForm.class);

    /** エンティティ登録フォームのリスト */
    @Valid
    private List<T00EntityRegistForm> t00EntityGrid;

    /**
     * @return エンティティ登録フォームのリスト
     */
    public List<T00EntityRegistForm> getT00EntityGrid() {
        return t00EntityGrid;
    }

    /**
     * @param p エンティティ登録フォームのリスト
     */
    public void setT00EntityGrid(final List<T00EntityRegistForm> p) {
        this.t00EntityGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        if (this.t00EntityGrid != null) {
            for (int i = 0; i < this.t00EntityGrid.size(); i++) {
                T00EntityRegistForm form = this.t00EntityGrid.get(i);
                if (form != null) {
                    Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                    form.validate(gridErrors, baseProcess);
                    BaseProcess.copyGridErrors(errors, "T00EntityGrid", i, gridErrors);
                }
            }
        }
    }

}
