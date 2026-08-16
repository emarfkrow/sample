package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.entity.T07Derive2;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 派生２一覧削除
 *
 * @author emarfkrow
 */
public class T07Derive2SDeleteAction extends BaseAction {

    /** 派生２一覧削除処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> form) {

        Map<String, Object> map = new HashMap<String, Object>();

        int count = 0;

        @SuppressWarnings("unchecked")
        List<Map<String, Object>> data = (List<Map<String, Object>>) form.get("T07Derive2Grid");
        if (data != null) {
            for (Map<String, Object> row : data) {

                if (row.isEmpty()) {
                    continue;
                }

                // 主キーが不足していたらエラー
                if (jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(row.get("DERIVE2_ID"))) {
                    throw new OptLockError("error.cant.delete", "派生２");
                }

                T07Derive2 e = FormValidator.toBean(T07Derive2.class.getName(), row);

                java.util.List<com.example.entity.T07Derive2Det> t07Derive2Dets = e.referT07Derive2Dets();
                if (t07Derive2Dets != null) {
                    for (com.example.entity.T07Derive2Det t07Derive2Det : t07Derive2Dets) {

                        if (t07Derive2Det.delete() != 1) {
                            throw new OptLockError("error.cant.delete", "派生２明細");
                        }
                    }
                }

                if (e.delete() != 1) {
                    throw new OptLockError("error.cant.delete", "派生２");
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
