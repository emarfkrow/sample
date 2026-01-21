package com.example.action.D0000;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.Tb4Ko;
import com.example.entity.Tb4Oya;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.AppError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 詳細画面登録アクション
 * @author toshiyuki
 *
 */
public class D0002RegistAction extends BaseAction {

    /**
     *
     */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String id, final Map<String, Object> postJson) {

        Tb4Ko tKo = FormValidator.toBean(Tb4Ko.class.getName(), postJson);

        //        TEntity2 tEntity2 = FormValidator.toBean(TEntity2.class.getName(), postJson);
        //        tEntity.setTEntity2(tEntity2);

        Tb4Oya tOya = FormValidator.toBean(Tb4Oya.class.getName(), postJson);
        tOya.addTb4Kos(tKo);

        if (tOya.insert(now, id) != 1) {
            throw new AppError("error.cant.insert");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.insert"));
        return map;
    }

}
