package me.dustin.example.mixins;

import me.dustin.jex.feature.mod.core.Feature;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.gen.Invoker;

import java.util.ArrayList;
import java.util.Arrays;

@Mixin(Feature.Category.class)
public class MixinFeatureCategory {

    @Shadow @Final @Mutable private static Feature.Category[] $VALUES;

    //you can add your own categories to Jex using this method. To set the category for a mod, just set to MISC in the @Manifest and then create a constructor calling setFeatureCategory(Feature.Category.valueOf("EXAMPLE"));
    private static final Feature.Category EXAMPLE = addCategory("EXAMPLE");

    @Invoker("<init>")
    public static Feature.Category invokeInit(String name, int id) {
        throw new AssertionError();
    }

    private static Feature.Category addCategory(String name) {
        ArrayList<Feature.Category> categories = new ArrayList<>(Arrays.asList(MixinFeatureCategory.$VALUES));
        Feature.Category newCategory = invokeInit(name, categories.get(categories.size() - 1).ordinal() + 1);
        categories.add(newCategory);
        MixinFeatureCategory.$VALUES = categories.toArray(new Feature.Category[0]);
        return newCategory;
    }
}
