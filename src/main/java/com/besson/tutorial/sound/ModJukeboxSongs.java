package com.besson.tutorial.sound;

import com.besson.tutorial.TutorialMod;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Util;
import net.minecraft.world.item.JukeboxSong;

public interface ModJukeboxSongs {
    ResourceKey<JukeboxSong> A_MOMENT_APART = create("a_moment_apart");
    private static ResourceKey<JukeboxSong> create(final String id) {
        return ResourceKey.create(Registries.JUKEBOX_SONG, Identifier.fromNamespaceAndPath(TutorialMod.MOD_ID, id));
    }

    static void bootstrap(BootstrapContext<JukeboxSong> context) {
        register(context, A_MOMENT_APART, ModSoundEvents.A_MOMENT_APART_MUSIC_DISC, 235, 15);
    }
    
    private static void register(
            final BootstrapContext<JukeboxSong> context,
            final ResourceKey<JukeboxSong> registryKey,
            final Holder.Reference<SoundEvent> soundEvent,
            final int lengthInSeconds,
            final int comparatorOutput
    ) {
        context.register(
                registryKey,
                new JukeboxSong(soundEvent, Component.translatable(Util.makeDescriptionId("jukebox_song", registryKey.identifier())), lengthInSeconds, comparatorOutput)
        );
    }
}
