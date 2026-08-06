# Supreme Gold

一个用 **NeoForge 1.20.1** 开发的 Minecraft 内容模组。

- **mod_id**: `supreme_gold`
- **显示名**: Supreme Gold（至尊金）
- **当前内容**: 三种自定义矿石、锭以及装备，添加了匠魂支持
- **加载器**: NeoForge `1.20.1-47.1.106`（Maven 坐标 `net.neoforged:forge`）
- **语言**: Java 17


## Tinkers' Construct（匠魂）兼容

装载匠魂后，三种被添加的材料会成为**匠魂材料**，可以被熔融、浇铸、组装。
## 项目结构
```
src/main/java/com/example/testmod/
├── TestMod.java                 # 模组入口
├── block/ModBlocks.java         # 方块注册
├── item/ModItems.java           # 物品/工具/装备/创造标签页注册
├── item/SupremeGoldArmorMaterial.java  # 至尊金护甲材料
├── item/SupremeIronArmorMaterial.java  # 终极铁护甲材料
├── fluid/ModFluids.java         # 熔融至尊金流体
├── fluid/MoltenSupremeGoldFluidType.java  # 流体客户端贴图
└── event/ModEvents.java         # 至尊金工具特性
src/main/resources/
├── META-INF/mods.toml           # 模组元数据
├── pack.mcmeta
├── assets/supreme_gold/         # 模组资源
├── assets/minecraft/textures/models/armor/  # 护甲层贴图
├── data/supreme_gold/           # 配方/掉落物/worldgen/biome_modifier/匠魂数据
├── data/minecraft/tags/         # 挖掘等级 tag
├── data/forge/tags/             # 匠魂材料/熔融流体 tag
└── icon.png                     # 模组图标
```
**本项目所有代码由ai生成**
