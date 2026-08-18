package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.MsyTax;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 税マスタ削除
 *
 * @author emarfkrow
 */
public class MsyTaxDeleteAction extends BaseAction {

    /** 税マスタ削除処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime at, final String by, final Map<String, Object> form) {

        // 主キーが不足していたらエラー
        Object taxKb = form.get("taxKb");
        if (taxKb == null) {
            taxKb = form.get("MsyTax.taxKb");
        }
        if (taxKb == null) {
            throw new OptLockError("error.cant.delete", "税マスタ");
        }
        Object tekiyoBi = form.get("tekiyoBi");
        if (tekiyoBi == null) {
            tekiyoBi = form.get("MsyTax.tekiyoBi");
        }
        if (tekiyoBi == null) {
            throw new OptLockError("error.cant.delete", "税マスタ");
        }

        MsyTax e = FormValidator.toBean(MsyTax.class.getName(), form);
        if (e.delete() != 1) {
            throw new OptLockError("error.cant.delete", "税マスタ");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.delete"));
        return map;
    }

}
