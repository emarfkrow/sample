package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.MsyTsuka;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * MSY_TSUKA照会
 *
 * @author emarfkrow
 */
public class MsyTsukaGetAction extends BaseAction {

    /** MSY_TSUKA照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime at, final String by, final Map<String, Object> form) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object tsukaKb = form.get("tsukaKb");
        if (tsukaKb == null) {
            tsukaKb = form.get("MsyTsuka.tsukaKb");
        }
        if (tsukaKb == null) {
            isAllKey = false;
        }

        Object tekiyoBi = form.get("tekiyoBi");
        if (tekiyoBi == null) {
            tekiyoBi = form.get("MsyTsuka.tekiyoBi");
        }
        if (tekiyoBi == null) {
            isAllKey = false;
        }

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            MsyTsuka msyTsuka = MsyTsuka.get(tsukaKb, tekiyoBi);
            map.put("MsyTsuka", msyTsuka);
        } catch (NoDataError e) {
            if (form.get("IsSilent") == null || !form.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
