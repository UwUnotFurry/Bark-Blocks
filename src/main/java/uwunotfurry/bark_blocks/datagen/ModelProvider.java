package uwunotfurry.bark_blocks.datagen;

import java.util.Optional;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;

import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.blockstates.BlockModelDefinitionGenerator;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.PropertyDispatch;
import net.minecraft.client.data.models.model.ModelLocationUtils;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.core.Direction;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;

import uwunotfurry.bark_blocks.BarkBlocks;
import uwunotfurry.bark_blocks.world.level.block.Blocks;
import uwunotfurry.bark_blocks.world.level.block.HollowRotatedPillarBlock;

public class ModelProvider extends FabricModelProvider {

	public static final ModelTemplate HOLLOW_COLUMN = new ModelTemplate(Optional.of(Identifier.fromNamespaceAndPath(BarkBlocks.MOD_ID, "block/hollow_column")), Optional.empty(), TextureSlot.SIDE, TextureSlot.TOP, TextureSlot.INSIDE);

	public ModelProvider(FabricDataOutput output) {
		super(output);
	}

	@Override
	public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator) {
		registerBarkBlock(blockStateModelGenerator, Blocks.OAK_BARK,		net.minecraft.world.level.block.Blocks.OAK_LOG,			net.minecraft.world.level.block.Blocks.STRIPPED_OAK_LOG);
		registerBarkBlock(blockStateModelGenerator, Blocks.SPRUCE_BARK,		net.minecraft.world.level.block.Blocks.SPRUCE_LOG,		net.minecraft.world.level.block.Blocks.STRIPPED_SPRUCE_LOG);
		registerBarkBlock(blockStateModelGenerator, Blocks.BIRCH_BARK,		net.minecraft.world.level.block.Blocks.BIRCH_LOG,		net.minecraft.world.level.block.Blocks.STRIPPED_BIRCH_LOG);
		registerBarkBlock(blockStateModelGenerator, Blocks.JUNGLE_BARK,		net.minecraft.world.level.block.Blocks.JUNGLE_LOG,		net.minecraft.world.level.block.Blocks.STRIPPED_JUNGLE_LOG);
		registerBarkBlock(blockStateModelGenerator, Blocks.ACACIA_BARK,		net.minecraft.world.level.block.Blocks.ACACIA_LOG,		net.minecraft.world.level.block.Blocks.STRIPPED_ACACIA_LOG);
		registerBarkBlock(blockStateModelGenerator, Blocks.DARK_OAK_BARK,	net.minecraft.world.level.block.Blocks.DARK_OAK_LOG,	net.minecraft.world.level.block.Blocks.STRIPPED_DARK_OAK_LOG);
		registerBarkBlock(blockStateModelGenerator, Blocks.MANGROVE_BARK,	net.minecraft.world.level.block.Blocks.MANGROVE_LOG,	net.minecraft.world.level.block.Blocks.STRIPPED_MANGROVE_LOG);
		registerBarkBlock(blockStateModelGenerator, Blocks.CHERRY_BARK,		net.minecraft.world.level.block.Blocks.CHERRY_LOG,		net.minecraft.world.level.block.Blocks.STRIPPED_CHERRY_LOG);
		registerBarkBlock(blockStateModelGenerator, Blocks.PALE_OAK_BARK,	net.minecraft.world.level.block.Blocks.PALE_OAK_LOG,	net.minecraft.world.level.block.Blocks.STRIPPED_PALE_OAK_LOG);
		registerBarkBlock(blockStateModelGenerator, Blocks.CRIMSON_ANNULUS,	net.minecraft.world.level.block.Blocks.CRIMSON_STEM,	net.minecraft.world.level.block.Blocks.STRIPPED_CRIMSON_STEM);
		registerBarkBlock(blockStateModelGenerator, Blocks.WARPED_ANNULUS,	net.minecraft.world.level.block.Blocks.WARPED_STEM,		net.minecraft.world.level.block.Blocks.STRIPPED_WARPED_STEM);
	}
	@Override
	public void generateItemModels(ItemModelGenerators itemModelGenerator) {}
	@Override
	public String getName() {
		return "Bark Blocks Model Provider";
	}

	public static void registerBarkBlock(BlockModelGenerators generator, Block block, Block logBlock, Block strippedBlock) {
		TextureMapping textures = new TextureMapping()
			.put(TextureSlot.SIDE, ModelLocationUtils.getModelLocation(logBlock))
			.put(TextureSlot.TOP, ModelLocationUtils.getModelLocation(logBlock, "_top"))
			.put(TextureSlot.INSIDE, ModelLocationUtils.getModelLocation(strippedBlock));

		Identifier blockModel = HOLLOW_COLUMN.create(block, textures, generator.modelOutput);
		generator.blockStateOutput.accept(createHollowRotatedPillarBlockStates(block, blockModel));
		generator.registerSimpleItemModel(block, blockModel);
	}
	public static BlockModelDefinitionGenerator createHollowRotatedPillarBlockStates(Block block, Identifier blockLocation) {
		MultiVariant hollowColumnModel = BlockModelGenerators.plainVariant(blockLocation);
		return MultiVariantGenerator.dispatch(block)
			.with(PropertyDispatch.initial(HollowRotatedPillarBlock.AXIS)
				.select(Direction.Axis.X, hollowColumnModel.with(BlockModelGenerators.Y_ROT_90).with(BlockModelGenerators.X_ROT_90))
				.select(Direction.Axis.Y, hollowColumnModel)
				.select(Direction.Axis.Z, hollowColumnModel.with(BlockModelGenerators.X_ROT_90))
			)
		;
	}
}