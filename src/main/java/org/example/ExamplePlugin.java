package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import team.starworld.shark.SharkBotApplication;
import team.starworld.shark.data.plugin.Plugin;
import team.starworld.shark.event.application.plugin.PluginLoadEvent;
import team.starworld.shark.event.application.resources.ResourceLoadFinishEvent;
import team.starworld.shark.network.chat.Component;

@SuppressWarnings("unused")
@Plugin(id = ExamplePlugin.PLUGIN_ID)
public class ExamplePlugin {

    public static final String PLUGIN_ID = "example_plugin";
    public static final Logger LOGGER = LoggerFactory.getLogger(ExamplePlugin.class);

    public ExamplePlugin (PluginLoadEvent event) {
        SharkBotApplication.RESOURCE_LOADER.eventBus.once(ResourceLoadFinishEvent.class, this::onResourceLoadFinish);
    }

    private void onResourceLoadFinish (ResourceLoadFinishEvent event) {
        LOGGER.info(Component.translatable("example_plugin.message").toString());
    }

}