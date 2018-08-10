package com.qxb.student.common.rong;

import java.util.ArrayList;
import java.util.List;

import io.rong.imkit.DefaultExtensionModule;
import io.rong.imkit.plugin.IPluginModule;
import io.rong.imkit.plugin.ImagePlugin;
import io.rong.imlib.model.Conversation;

/**
 * 自定义扩展功能区
 * Created by winky on 2017/12/7.
 */
public class ExtensionModule extends DefaultExtensionModule {

    public ExtensionModule() {
        super();
    }

    @Override
    public List<IPluginModule> getPluginModules(Conversation.ConversationType conversationType) {
        ArrayList pluginModuleList = new ArrayList();
        ImagePlugin image = new ImagePlugin();
//        EvaluatePlugin evaluate = new EvaluatePlugin();
        if (conversationType.equals(Conversation.ConversationType.CHATROOM)) {
            pluginModuleList.add(image);
        } else if (conversationType.equals(Conversation.ConversationType.PRIVATE)) {
            pluginModuleList.add(image);
//            pluginModuleList.add(evaluate);
        }
        return pluginModuleList;
    }
}

