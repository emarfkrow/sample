package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.entity.M05Id;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * IDマスタ一覧登録
 *
 * @author emarfkrow
 */
public class M05IdSRegistAction extends BaseAction {

    /** IDマスタ一覧登録処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime at, final String by, final Map<String, Object> form) {

        Map<String, Object> map = new HashMap<String, Object>();

        int count = 0;

        @SuppressWarnings("unchecked")
        List<Map<String, Object>> data = (List<Map<String, Object>>) form.get("M05IdGrid");
        if (data != null) {
            for (Map<String, Object> row : data) {

                if (row.isEmpty()) {
                    continue;
                }

                M05Id e = FormValidator.toBean(M05Id.class.getName(), row);

                if (e.isNew()) {

                    if (e.insert(at, by) != 1) {
                        throw new OptLockError("error.cant.insert", "IDマスタ");
                    }
                    ++count;

                } else {

                    if (e.update(at, by) != 1) {
                        throw new OptLockError("error.cant.update", "IDマスタ");
                    }
                    ++count;
                }
            }
        }

        if (count == 0) {
            map.put("ERROR", Messages.get("error.nopost"));
            return map;
        }

        map.put("INFO", Messages.get("info.regist"));
        return map;
    }

}
