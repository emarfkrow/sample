package com.example.action.D0000;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.util.Messages;

/**
 * 検索画面登録アクション
 * @author toshiyuki
 *
 */
public class D0001RegistAction extends BaseAction {

    /**
     *
     */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String id, final Map<String, Object> postJson) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.regist"));
        return map;
    }

}
