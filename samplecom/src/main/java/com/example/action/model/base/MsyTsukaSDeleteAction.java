package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.entity.MsyTsuka;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 通貨マスタ一覧削除
 *
 * @author emarfkrow
 */
public class MsyTsukaSDeleteAction extends BaseAction {

    /** 通貨マスタ一覧削除処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> form) {

        Map<String, Object> map = new HashMap<String, Object>();

        int count = 0;

        @SuppressWarnings("unchecked")
        List<Map<String, Object>> data = (List<Map<String, Object>>) form.get("MsyTsukaGrid");
        if (data != null) {
            for (Map<String, Object> row : data) {

                if (row.isEmpty()) {
                    continue;
                }

                // 主キーが不足していたらエラー
                if (jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(row.get("TSUKA_KB"))) {
                    throw new OptLockError("error.cant.delete", "通貨マスタ");
                }
                if (jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(row.get("TEKIYO_BI"))) {
                    throw new OptLockError("error.cant.delete", "通貨マスタ");
                }

                MsyTsuka e = FormValidator.toBean(MsyTsuka.class.getName(), row);
                if (e.delete() != 1) {
                    throw new OptLockError("error.cant.delete", "通貨マスタ");
                }
                ++count;
            }
        }

        if (count == 0) {
            map.put("ERROR", Messages.get("error.nopost"));
            return map;
        }

        map.put("INFO", Messages.get("info.delete"));
        return map;
    }

}
