package com.example.testmod.fluid;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions;
import net.minecraftforge.fluids.FluidType;

import java.util.function.Consumer;

/**
 * Molten Supreme Gold fluid type - feeds the gold still/flowing textures into
 * the client rendering pipeline via the common-side {@link #initializeClient}
 * hook, so this class loads on both client and dedicated server.
 */
public class MoltenSupremeGoldFluidType extends FluidType {
    private final ResourceLocation stillTexture;
    private final ResourceLocation flowingTexture;

    public MoltenSupremeGoldFluidType(Properties properties, ResourceLocation stillTexture,
                                      ResourceLocation flowingTexture) {
        super(properties);
        this.stillTexture = stillTexture;
        this.flowingTexture = flowingTexture;
    }

    @Override
    public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {
        consumer.accept(new IClientFluidTypeExtensions() {
            @Override
            public ResourceLocation getStillTexture() {
                return stillTexture;
            }

            @Override
            public ResourceLocation getFlowingTexture() {
                return flowingTexture;
            }
        });
    }
}
