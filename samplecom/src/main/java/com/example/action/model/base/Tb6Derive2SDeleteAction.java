package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.entity.Tb6Derive2;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 派生２一覧削除
 *
 * @author emarfkrow
 */
public class Tb6Derive2SDeleteAction extends BaseAction {

    /** 派生２一覧削除処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> form) {

        Map<String, Object> map = new HashMap<String, Object>();

        int count = 0;

        @SuppressWarnings("unchecked")
        List<Map<String, Object>> data = (List<Map<String, Object>>) form.get("Tb6Derive2Grid");
        if (data != null) {
            for (Map<String, Object> row : data) {

                if (row.isEmpty()) {
                    continue;
                }

                // 主キーが不足していたらエラー
                if (jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(row.get("DERIVE2_ID"))) {
                    throw new OptLockError("error.cant.delete", "派生２");
                }

                Tb6Derive2 e = FormValidator.toBean(Tb6Derive2.class.getName(), row);

                java.util.List<com.example.entity.Tb6Derive2Det> tb6Derive2Dets = e.referTb6Derive2Dets();
                if (tb6Derive2Dets != null) {
                    for (com.example.entity.Tb6Derive2Det tb6Derive2Det : tb6Derive2Dets) {

                        if (tb6Derive2Det.delete() != 1) {
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
