package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 統合一覧登録フォーム
 *
 * @author emarfkrow
 */
public class Tb5MergeSRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(Tb5MergeRegistForm.class);

    /** 統合登録フォームのリスト */
    @Valid
    private List<Tb5MergeRegistForm> tb5MergeGrid;

    /**
     * @return 統合登録フォームのリスト
     */
    public List<Tb5MergeRegistForm> getTb5MergeGrid() {
        return tb5MergeGrid;
    }

    /**
     * @param p 統合登録フォームのリスト
     */
    public void setTb5MergeGrid(final List<Tb5MergeRegistForm> p) {
        this.tb5MergeGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        for (int i = 0; i < this.tb5MergeGrid.size(); i++) {
            Tb5MergeRegistForm form = this.tb5MergeGrid.get(i);
            if (form != null) {
                Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                form.validate(gridErrors, baseProcess);
                BaseProcess.copyGridErrors(errors, "Tb5MergeGrid", i, gridErrors);
            }
        }
    }

}
