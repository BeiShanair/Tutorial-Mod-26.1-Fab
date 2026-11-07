package com.besson.tutorial.sound;

import com.besson.tutorial.TutorialMod;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.block.SoundType;

public class ModSoundEvents {
    public static final SoundEvent PROSPECTOR_FOUND_ORE = register("prospector_found_ore");
    public static final SoundEvent BLOCK_BREAK = register("block_break");
    public static final SoundEvent BLOCK_PLACE = register("block_place");
    public static final SoundEvent BLOCK_HIT = register("block_hit");
    public static final SoundEvent BLOCK_FALL = register("block_fall");
    public static final SoundEvent BLOCK_STEP = register("block_step");
    
    public static final SoundType ICE_ETHER_BLOCK_SOUND = new SoundType(
            1.0F, 1.0F,
            BLOCK_BREAK, BLOCK_STEP, BLOCK_PLACE, BLOCK_HIT, BLOCK_FALL);
    
    public static final Holder.Reference<SoundEvent> A_MOMENT_APART_MUSIC_DISC = registerForHolder("a_moment_apart_music_disc");
    
    private static Holder.Reference<SoundEvent> registerForHolder(String name) {
        Identifier id = Identifier.fromNamespaceAndPath(TutorialMod.MOD_ID, name);
        return Registry.registerForHolder(BuiltInRegistries.SOUND_EVENT, id, SoundEvent.createVariableRangeEvent(id));
    }
    
    private static SoundEvent register(String name) {
        Identifier id = Identifier.fromNamespaceAndPath(TutorialMod.MOD_ID, name);
        return Registry.register(BuiltInRegistries.SOUND_EVENT, id, SoundEvent.createVariableRangeEvent(id));
    }
}
