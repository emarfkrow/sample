package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.MsyTax;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * MSY_TAX照会
 *
 * @author emarfkrow
 */
public class MsyTaxGetAction extends BaseAction {

    /** MSY_TAX照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime at, final String by, final Map<String, Object> form) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object taxKb = form.get("taxKb");
        if (taxKb == null) {
            taxKb = form.get("MsyTax.taxKb");
        }
        if (taxKb == null) {
            isAllKey = false;
        }

        Object tekiyoBi = form.get("tekiyoBi");
        if (tekiyoBi == null) {
            tekiyoBi = form.get("MsyTax.tekiyoBi");
        }
        if (tekiyoBi == null) {
            isAllKey = false;
        }

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            MsyTax msyTax = MsyTax.get(taxKb, tekiyoBi);
            map.put("MsyTax", msyTax);
        } catch (NoDataError e) {
            if (form.get("IsSilent") == null || !form.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
