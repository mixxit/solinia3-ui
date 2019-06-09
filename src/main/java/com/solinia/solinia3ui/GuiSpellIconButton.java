package com.solinia.solinia3ui;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

public class GuiSpellIconButton extends GuiButton {

	protected static final ResourceLocation SPELLICON_0 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/0.png");
	protected static final ResourceLocation SPELLICON_1 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/1.png");
	protected static final ResourceLocation SPELLICON_10 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/10.png");
	protected static final ResourceLocation SPELLICON_100 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/100.png");
	protected static final ResourceLocation SPELLICON_101 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/101.png");
	protected static final ResourceLocation SPELLICON_102 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/102.png");
	protected static final ResourceLocation SPELLICON_103 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/103.png");
	protected static final ResourceLocation SPELLICON_104 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/104.png");
	protected static final ResourceLocation SPELLICON_105 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/105.png");
	protected static final ResourceLocation SPELLICON_106 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/106.png");
	protected static final ResourceLocation SPELLICON_107 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/107.png");
	protected static final ResourceLocation SPELLICON_108 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/108.png");
	protected static final ResourceLocation SPELLICON_109 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/109.png");
	protected static final ResourceLocation SPELLICON_11 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/11.png");
	protected static final ResourceLocation SPELLICON_110 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/110.png");
	protected static final ResourceLocation SPELLICON_111 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/111.png");
	protected static final ResourceLocation SPELLICON_112 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/112.png");
	protected static final ResourceLocation SPELLICON_113 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/113.png");
	protected static final ResourceLocation SPELLICON_114 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/114.png");
	protected static final ResourceLocation SPELLICON_115 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/115.png");
	protected static final ResourceLocation SPELLICON_116 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/116.png");
	protected static final ResourceLocation SPELLICON_117 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/117.png");
	protected static final ResourceLocation SPELLICON_118 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/118.png");
	protected static final ResourceLocation SPELLICON_119 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/119.png");
	protected static final ResourceLocation SPELLICON_12 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/12.png");
	protected static final ResourceLocation SPELLICON_120 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/120.png");
	protected static final ResourceLocation SPELLICON_121 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/121.png");
	protected static final ResourceLocation SPELLICON_122 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/122.png");
	protected static final ResourceLocation SPELLICON_123 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/123.png");
	protected static final ResourceLocation SPELLICON_124 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/124.png");
	protected static final ResourceLocation SPELLICON_125 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/125.png");
	protected static final ResourceLocation SPELLICON_126 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/126.png");
	protected static final ResourceLocation SPELLICON_127 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/127.png");
	protected static final ResourceLocation SPELLICON_128 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/128.png");
	protected static final ResourceLocation SPELLICON_129 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/129.png");
	protected static final ResourceLocation SPELLICON_13 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/13.png");
	protected static final ResourceLocation SPELLICON_130 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/130.png");
	protected static final ResourceLocation SPELLICON_131 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/131.png");
	protected static final ResourceLocation SPELLICON_132 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/132.png");
	protected static final ResourceLocation SPELLICON_133 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/133.png");
	protected static final ResourceLocation SPELLICON_134 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/134.png");
	protected static final ResourceLocation SPELLICON_135 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/135.png");
	protected static final ResourceLocation SPELLICON_136 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/136.png");
	protected static final ResourceLocation SPELLICON_137 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/137.png");
	protected static final ResourceLocation SPELLICON_138 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/138.png");
	protected static final ResourceLocation SPELLICON_139 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/139.png");
	protected static final ResourceLocation SPELLICON_14 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/14.png");
	protected static final ResourceLocation SPELLICON_140 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/140.png");
	protected static final ResourceLocation SPELLICON_141 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/141.png");
	protected static final ResourceLocation SPELLICON_142 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/142.png");
	protected static final ResourceLocation SPELLICON_143 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/143.png");
	protected static final ResourceLocation SPELLICON_144 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/144.png");
	protected static final ResourceLocation SPELLICON_145 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/145.png");
	protected static final ResourceLocation SPELLICON_146 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/146.png");
	protected static final ResourceLocation SPELLICON_147 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/147.png");
	protected static final ResourceLocation SPELLICON_148 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/148.png");
	protected static final ResourceLocation SPELLICON_149 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/149.png");
	protected static final ResourceLocation SPELLICON_15 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/15.png");
	protected static final ResourceLocation SPELLICON_150 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/150.png");
	protected static final ResourceLocation SPELLICON_151 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/151.png");
	protected static final ResourceLocation SPELLICON_152 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/152.png");
	protected static final ResourceLocation SPELLICON_153 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/153.png");
	protected static final ResourceLocation SPELLICON_154 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/154.png");
	protected static final ResourceLocation SPELLICON_155 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/155.png");
	protected static final ResourceLocation SPELLICON_156 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/156.png");
	protected static final ResourceLocation SPELLICON_157 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/157.png");
	protected static final ResourceLocation SPELLICON_158 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/158.png");
	protected static final ResourceLocation SPELLICON_159 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/159.png");
	protected static final ResourceLocation SPELLICON_16 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/16.png");
	protected static final ResourceLocation SPELLICON_160 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/160.png");
	protected static final ResourceLocation SPELLICON_161 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/161.png");
	protected static final ResourceLocation SPELLICON_162 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/162.png");
	protected static final ResourceLocation SPELLICON_163 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/163.png");
	protected static final ResourceLocation SPELLICON_164 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/164.png");
	protected static final ResourceLocation SPELLICON_165 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/165.png");
	protected static final ResourceLocation SPELLICON_166 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/166.png");
	protected static final ResourceLocation SPELLICON_167 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/167.png");
	protected static final ResourceLocation SPELLICON_168 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/168.png");
	protected static final ResourceLocation SPELLICON_169 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/169.png");
	protected static final ResourceLocation SPELLICON_17 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/17.png");
	protected static final ResourceLocation SPELLICON_170 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/170.png");
	protected static final ResourceLocation SPELLICON_171 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/171.png");
	protected static final ResourceLocation SPELLICON_172 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/172.png");
	protected static final ResourceLocation SPELLICON_173 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/173.png");
	protected static final ResourceLocation SPELLICON_174 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/174.png");
	protected static final ResourceLocation SPELLICON_175 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/175.png");
	protected static final ResourceLocation SPELLICON_176 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/176.png");
	protected static final ResourceLocation SPELLICON_177 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/177.png");
	protected static final ResourceLocation SPELLICON_178 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/178.png");
	protected static final ResourceLocation SPELLICON_179 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/179.png");
	protected static final ResourceLocation SPELLICON_18 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/18.png");
	protected static final ResourceLocation SPELLICON_180 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/180.png");
	protected static final ResourceLocation SPELLICON_181 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/181.png");
	protected static final ResourceLocation SPELLICON_182 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/182.png");
	protected static final ResourceLocation SPELLICON_183 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/183.png");
	protected static final ResourceLocation SPELLICON_184 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/184.png");
	protected static final ResourceLocation SPELLICON_185 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/185.png");
	protected static final ResourceLocation SPELLICON_186 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/186.png");
	protected static final ResourceLocation SPELLICON_187 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/187.png");
	protected static final ResourceLocation SPELLICON_188 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/188.png");
	protected static final ResourceLocation SPELLICON_189 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/189.png");
	protected static final ResourceLocation SPELLICON_19 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/19.png");
	protected static final ResourceLocation SPELLICON_190 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/190.png");
	protected static final ResourceLocation SPELLICON_191 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/191.png");
	protected static final ResourceLocation SPELLICON_192 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/192.png");
	protected static final ResourceLocation SPELLICON_193 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/193.png");
	protected static final ResourceLocation SPELLICON_194 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/194.png");
	protected static final ResourceLocation SPELLICON_195 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/195.png");
	protected static final ResourceLocation SPELLICON_196 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/196.png");
	protected static final ResourceLocation SPELLICON_197 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/197.png");
	protected static final ResourceLocation SPELLICON_198 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/198.png");
	protected static final ResourceLocation SPELLICON_199 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/199.png");
	protected static final ResourceLocation SPELLICON_2 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/2.png");
	protected static final ResourceLocation SPELLICON_20 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/20.png");
	protected static final ResourceLocation SPELLICON_200 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/200.png");
	protected static final ResourceLocation SPELLICON_201 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/201.png");
	protected static final ResourceLocation SPELLICON_202 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/202.png");
	protected static final ResourceLocation SPELLICON_203 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/203.png");
	protected static final ResourceLocation SPELLICON_204 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/204.png");
	protected static final ResourceLocation SPELLICON_205 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/205.png");
	protected static final ResourceLocation SPELLICON_206 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/206.png");
	protected static final ResourceLocation SPELLICON_207 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/207.png");
	protected static final ResourceLocation SPELLICON_208 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/208.png");
	protected static final ResourceLocation SPELLICON_209 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/209.png");
	protected static final ResourceLocation SPELLICON_21 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/21.png");
	protected static final ResourceLocation SPELLICON_210 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/210.png");
	protected static final ResourceLocation SPELLICON_211 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/211.png");
	protected static final ResourceLocation SPELLICON_212 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/212.png");
	protected static final ResourceLocation SPELLICON_213 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/213.png");
	protected static final ResourceLocation SPELLICON_214 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/214.png");
	protected static final ResourceLocation SPELLICON_215 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/215.png");
	protected static final ResourceLocation SPELLICON_216 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/216.png");
	protected static final ResourceLocation SPELLICON_217 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/217.png");
	protected static final ResourceLocation SPELLICON_218 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/218.png");
	protected static final ResourceLocation SPELLICON_219 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/219.png");
	protected static final ResourceLocation SPELLICON_22 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/22.png");
	protected static final ResourceLocation SPELLICON_220 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/220.png");
	protected static final ResourceLocation SPELLICON_221 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/221.png");
	protected static final ResourceLocation SPELLICON_222 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/222.png");
	protected static final ResourceLocation SPELLICON_223 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/223.png");
	protected static final ResourceLocation SPELLICON_224 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/224.png");
	protected static final ResourceLocation SPELLICON_225 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/225.png");
	protected static final ResourceLocation SPELLICON_226 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/226.png");
	protected static final ResourceLocation SPELLICON_227 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/227.png");
	protected static final ResourceLocation SPELLICON_228 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/228.png");
	protected static final ResourceLocation SPELLICON_229 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/229.png");
	protected static final ResourceLocation SPELLICON_23 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/23.png");
	protected static final ResourceLocation SPELLICON_230 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/230.png");
	protected static final ResourceLocation SPELLICON_231 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/231.png");
	protected static final ResourceLocation SPELLICON_232 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/232.png");
	protected static final ResourceLocation SPELLICON_233 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/233.png");
	protected static final ResourceLocation SPELLICON_234 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/234.png");
	protected static final ResourceLocation SPELLICON_235 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/235.png");
	protected static final ResourceLocation SPELLICON_236 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/236.png");
	protected static final ResourceLocation SPELLICON_237 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/237.png");
	protected static final ResourceLocation SPELLICON_238 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/238.png");
	protected static final ResourceLocation SPELLICON_239 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/239.png");
	protected static final ResourceLocation SPELLICON_24 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/24.png");
	protected static final ResourceLocation SPELLICON_240 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/240.png");
	protected static final ResourceLocation SPELLICON_241 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/241.png");
	protected static final ResourceLocation SPELLICON_242 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/242.png");
	protected static final ResourceLocation SPELLICON_243 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/243.png");
	protected static final ResourceLocation SPELLICON_244 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/244.png");
	protected static final ResourceLocation SPELLICON_245 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/245.png");
	protected static final ResourceLocation SPELLICON_246 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/246.png");
	protected static final ResourceLocation SPELLICON_247 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/247.png");
	protected static final ResourceLocation SPELLICON_248 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/248.png");
	protected static final ResourceLocation SPELLICON_249 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/249.png");
	protected static final ResourceLocation SPELLICON_25 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/25.png");
	protected static final ResourceLocation SPELLICON_250 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/250.png");
	protected static final ResourceLocation SPELLICON_251 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/251.png");
	protected static final ResourceLocation SPELLICON_26 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/26.png");
	protected static final ResourceLocation SPELLICON_27 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/27.png");
	protected static final ResourceLocation SPELLICON_28 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/28.png");
	protected static final ResourceLocation SPELLICON_29 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/29.png");
	protected static final ResourceLocation SPELLICON_3 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/3.png");
	protected static final ResourceLocation SPELLICON_30 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/30.png");
	protected static final ResourceLocation SPELLICON_31 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/31.png");
	protected static final ResourceLocation SPELLICON_32 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/32.png");
	protected static final ResourceLocation SPELLICON_33 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/33.png");
	protected static final ResourceLocation SPELLICON_34 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/34.png");
	protected static final ResourceLocation SPELLICON_35 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/35.png");
	protected static final ResourceLocation SPELLICON_36 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/36.png");
	protected static final ResourceLocation SPELLICON_37 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/37.png");
	protected static final ResourceLocation SPELLICON_38 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/38.png");
	protected static final ResourceLocation SPELLICON_39 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/39.png");
	protected static final ResourceLocation SPELLICON_4 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/4.png");
	protected static final ResourceLocation SPELLICON_40 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/40.png");
	protected static final ResourceLocation SPELLICON_41 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/41.png");
	protected static final ResourceLocation SPELLICON_42 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/42.png");
	protected static final ResourceLocation SPELLICON_43 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/43.png");
	protected static final ResourceLocation SPELLICON_44 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/44.png");
	protected static final ResourceLocation SPELLICON_45 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/45.png");
	protected static final ResourceLocation SPELLICON_46 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/46.png");
	protected static final ResourceLocation SPELLICON_47 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/47.png");
	protected static final ResourceLocation SPELLICON_48 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/48.png");
	protected static final ResourceLocation SPELLICON_49 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/49.png");
	protected static final ResourceLocation SPELLICON_5 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/5.png");
	protected static final ResourceLocation SPELLICON_50 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/50.png");
	protected static final ResourceLocation SPELLICON_51 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/51.png");
	protected static final ResourceLocation SPELLICON_52 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/52.png");
	protected static final ResourceLocation SPELLICON_53 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/53.png");
	protected static final ResourceLocation SPELLICON_54 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/54.png");
	protected static final ResourceLocation SPELLICON_55 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/55.png");
	protected static final ResourceLocation SPELLICON_56 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/56.png");
	protected static final ResourceLocation SPELLICON_57 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/57.png");
	protected static final ResourceLocation SPELLICON_58 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/58.png");
	protected static final ResourceLocation SPELLICON_59 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/59.png");
	protected static final ResourceLocation SPELLICON_6 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/6.png");
	protected static final ResourceLocation SPELLICON_60 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/60.png");
	protected static final ResourceLocation SPELLICON_61 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/61.png");
	protected static final ResourceLocation SPELLICON_62 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/62.png");
	protected static final ResourceLocation SPELLICON_63 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/63.png");
	protected static final ResourceLocation SPELLICON_64 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/64.png");
	protected static final ResourceLocation SPELLICON_65 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/65.png");
	protected static final ResourceLocation SPELLICON_66 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/66.png");
	protected static final ResourceLocation SPELLICON_67 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/67.png");
	protected static final ResourceLocation SPELLICON_68 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/68.png");
	protected static final ResourceLocation SPELLICON_69 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/69.png");
	protected static final ResourceLocation SPELLICON_7 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/7.png");
	protected static final ResourceLocation SPELLICON_70 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/70.png");
	protected static final ResourceLocation SPELLICON_71 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/71.png");
	protected static final ResourceLocation SPELLICON_72 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/72.png");
	protected static final ResourceLocation SPELLICON_73 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/73.png");
	protected static final ResourceLocation SPELLICON_74 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/74.png");
	protected static final ResourceLocation SPELLICON_75 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/75.png");
	protected static final ResourceLocation SPELLICON_76 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/76.png");
	protected static final ResourceLocation SPELLICON_77 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/77.png");
	protected static final ResourceLocation SPELLICON_78 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/78.png");
	protected static final ResourceLocation SPELLICON_79 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/79.png");
	protected static final ResourceLocation SPELLICON_8 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/8.png");
	protected static final ResourceLocation SPELLICON_80 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/80.png");
	protected static final ResourceLocation SPELLICON_81 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/81.png");
	protected static final ResourceLocation SPELLICON_82 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/82.png");
	protected static final ResourceLocation SPELLICON_83 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/83.png");
	protected static final ResourceLocation SPELLICON_84 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/84.png");
	protected static final ResourceLocation SPELLICON_85 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/85.png");
	protected static final ResourceLocation SPELLICON_86 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/86.png");
	protected static final ResourceLocation SPELLICON_87 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/87.png");
	protected static final ResourceLocation SPELLICON_88 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/88.png");
	protected static final ResourceLocation SPELLICON_89 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/89.png");
	protected static final ResourceLocation SPELLICON_9 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/9.png");
	protected static final ResourceLocation SPELLICON_90 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/90.png");
	protected static final ResourceLocation SPELLICON_91 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/91.png");
	protected static final ResourceLocation SPELLICON_92 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/92.png");
	protected static final ResourceLocation SPELLICON_93 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/93.png");
	protected static final ResourceLocation SPELLICON_94 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/94.png");
	protected static final ResourceLocation SPELLICON_95 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/95.png");
	protected static final ResourceLocation SPELLICON_96 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/96.png");
	protected static final ResourceLocation SPELLICON_97 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/97.png");
	protected static final ResourceLocation SPELLICON_98 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/98.png");
	protected static final ResourceLocation SPELLICON_99 = new ResourceLocation( "solinia3ui", "textures/gui/newicons/99.png");
	private int spellIcon;

	public GuiSpellIconButton(int buttonId, int x, int y, String buttonText) {
		super(buttonId, x, y, buttonText);
	}
	
	public GuiSpellIconButton(int buttonId, int x, int y, int widthIn, int heightIn, String buttonText) {
		super(buttonId, x, y, widthIn, heightIn, buttonText);
	}

	@Override
	public void render(int mouseX, int mouseY, float partialTicks) {
		if (!this.visible)
			return;
		
		if (!displayString.contains("^"))
			return;
		
		String displayIconStr = this.displayString.split("\\^")[0];
		try
		{
			this.spellIcon = Integer.parseInt(displayIconStr);
		} catch (Exception e)
		{
			return;
		}
		
		if (this.spellIcon < 1)
			return;
		
		
		//Minecraft.getInstance().getTextureManager().bindTexture(SPELLTEXTURES1);
		//GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
		//this.hovered = mouseX >= this.x && mouseY >= this.y && mouseX < this.x + this.width
		//		&& mouseY < this.y + this.height;
		//int i = this.getHoverState(this.hovered);
		//int i = this.getHoverState(false); // we have only one icon
		//GlStateManager.enableBlend();
		//GlStateManager.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA,
		//		GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE,
		//		GlStateManager.DestFactor.ZERO);
		//GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA,
		//		GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
		//this.drawTexturedModalRect(this.x, this.y, 0, 46 + i * 20, this.width / 2, this.height);
		//this.drawTexturedModalRect(this.x + this.width / 2, this.y, 200 - this.width / 2, 46 + i * 20,
		//		this.width / 2, this.height);
		//this.renderBg(minecraft, mouseX, mouseY);
		ResourceLocation location = getSpellIconResourceLocation(this.spellIcon);
		if (location == null)
			return;
		
		Minecraft.getInstance().getTextureManager().bindTexture(location);
		drawSpellIcon(this.x, this.y);
		
		int j = 14737632;
		if (packedFGColor != 0) {
			j = packedFGColor;
		} else if (!this.enabled) {
			j = 10526880;
		} else if (this.hovered) {
			j = 16777120;
		}
		
		String displayString = this.displayString.split("\\^")[1];

		this.drawStringCenteredScale(Minecraft.getInstance().fontRenderer, displayString, this.x + this.width /2,this.y + (this.height - 8) + Minecraft.getInstance().fontRenderer.FONT_HEIGHT, 0.5f, j);
	}
	
	public void drawSpellIcon(int x, int y)
	{
		int texturex = 0;
		int texturey = 0;
		int sizex = 40;
		int sizey = 40;

		drawTexturedModalRect(x,y,texturex,texturey,sizex,sizey);
	}
	
	public void drawStringCenteredScale(FontRenderer fontRendererIn, String text, int x, int y, float size, int color) {
        GL11.glScalef(size,size,size);
        float mSize = (float)Math.pow(size,-1);
        this.drawCenteredString(fontRendererIn,text,Math.round(x / size),Math.round(y / size),color);
        GL11.glScalef(mSize,mSize,mSize);
    }
	
	public ResourceLocation getSpellIconResourceLocation(int newIconId) {
	    switch (newIconId) {
	        case 0:
	            return SPELLICON_0;
	        case 1:
	            return SPELLICON_1;
	        case 10:
	            return SPELLICON_10;
	        case 100:
	            return SPELLICON_100;
	        case 101:
	            return SPELLICON_101;
	        case 102:
	            return SPELLICON_102;
	        case 103:
	            return SPELLICON_103;
	        case 104:
	            return SPELLICON_104;
	        case 105:
	            return SPELLICON_105;
	        case 106:
	            return SPELLICON_106;
	        case 107:
	            return SPELLICON_107;
	        case 108:
	            return SPELLICON_108;
	        case 109:
	            return SPELLICON_109;
	        case 11:
	            return SPELLICON_11;
	        case 110:
	            return SPELLICON_110;
	        case 111:
	            return SPELLICON_111;
	        case 112:
	            return SPELLICON_112;
	        case 113:
	            return SPELLICON_113;
	        case 114:
	            return SPELLICON_114;
	        case 115:
	            return SPELLICON_115;
	        case 116:
	            return SPELLICON_116;
	        case 117:
	            return SPELLICON_117;
	        case 118:
	            return SPELLICON_118;
	        case 119:
	            return SPELLICON_119;
	        case 12:
	            return SPELLICON_12;
	        case 120:
	            return SPELLICON_120;
	        case 121:
	            return SPELLICON_121;
	        case 122:
	            return SPELLICON_122;
	        case 123:
	            return SPELLICON_123;
	        case 124:
	            return SPELLICON_124;
	        case 125:
	            return SPELLICON_125;
	        case 126:
	            return SPELLICON_126;
	        case 127:
	            return SPELLICON_127;
	        case 128:
	            return SPELLICON_128;
	        case 129:
	            return SPELLICON_129;
	        case 13:
	            return SPELLICON_13;
	        case 130:
	            return SPELLICON_130;
	        case 131:
	            return SPELLICON_131;
	        case 132:
	            return SPELLICON_132;
	        case 133:
	            return SPELLICON_133;
	        case 134:
	            return SPELLICON_134;
	        case 135:
	            return SPELLICON_135;
	        case 136:
	            return SPELLICON_136;
	        case 137:
	            return SPELLICON_137;
	        case 138:
	            return SPELLICON_138;
	        case 139:
	            return SPELLICON_139;
	        case 14:
	            return SPELLICON_14;
	        case 140:
	            return SPELLICON_140;
	        case 141:
	            return SPELLICON_141;
	        case 142:
	            return SPELLICON_142;
	        case 143:
	            return SPELLICON_143;
	        case 144:
	            return SPELLICON_144;
	        case 145:
	            return SPELLICON_145;
	        case 146:
	            return SPELLICON_146;
	        case 147:
	            return SPELLICON_147;
	        case 148:
	            return SPELLICON_148;
	        case 149:
	            return SPELLICON_149;
	        case 15:
	            return SPELLICON_15;
	        case 150:
	            return SPELLICON_150;
	        case 151:
	            return SPELLICON_151;
	        case 152:
	            return SPELLICON_152;
	        case 153:
	            return SPELLICON_153;
	        case 154:
	            return SPELLICON_154;
	        case 155:
	            return SPELLICON_155;
	        case 156:
	            return SPELLICON_156;
	        case 157:
	            return SPELLICON_157;
	        case 158:
	            return SPELLICON_158;
	        case 159:
	            return SPELLICON_159;
	        case 16:
	            return SPELLICON_16;
	        case 160:
	            return SPELLICON_160;
	        case 161:
	            return SPELLICON_161;
	        case 162:
	            return SPELLICON_162;
	        case 163:
	            return SPELLICON_163;
	        case 164:
	            return SPELLICON_164;
	        case 165:
	            return SPELLICON_165;
	        case 166:
	            return SPELLICON_166;
	        case 167:
	            return SPELLICON_167;
	        case 168:
	            return SPELLICON_168;
	        case 169:
	            return SPELLICON_169;
	        case 17:
	            return SPELLICON_17;
	        case 170:
	            return SPELLICON_170;
	        case 171:
	            return SPELLICON_171;
	        case 172:
	            return SPELLICON_172;
	        case 173:
	            return SPELLICON_173;
	        case 174:
	            return SPELLICON_174;
	        case 175:
	            return SPELLICON_175;
	        case 176:
	            return SPELLICON_176;
	        case 177:
	            return SPELLICON_177;
	        case 178:
	            return SPELLICON_178;
	        case 179:
	            return SPELLICON_179;
	        case 18:
	            return SPELLICON_18;
	        case 180:
	            return SPELLICON_180;
	        case 181:
	            return SPELLICON_181;
	        case 182:
	            return SPELLICON_182;
	        case 183:
	            return SPELLICON_183;
	        case 184:
	            return SPELLICON_184;
	        case 185:
	            return SPELLICON_185;
	        case 186:
	            return SPELLICON_186;
	        case 187:
	            return SPELLICON_187;
	        case 188:
	            return SPELLICON_188;
	        case 189:
	            return SPELLICON_189;
	        case 19:
	            return SPELLICON_19;
	        case 190:
	            return SPELLICON_190;
	        case 191:
	            return SPELLICON_191;
	        case 192:
	            return SPELLICON_192;
	        case 193:
	            return SPELLICON_193;
	        case 194:
	            return SPELLICON_194;
	        case 195:
	            return SPELLICON_195;
	        case 196:
	            return SPELLICON_196;
	        case 197:
	            return SPELLICON_197;
	        case 198:
	            return SPELLICON_198;
	        case 199:
	            return SPELLICON_199;
	        case 2:
	            return SPELLICON_2;
	        case 20:
	            return SPELLICON_20;
	        case 200:
	            return SPELLICON_200;
	        case 201:
	            return SPELLICON_201;
	        case 202:
	            return SPELLICON_202;
	        case 203:
	            return SPELLICON_203;
	        case 204:
	            return SPELLICON_204;
	        case 205:
	            return SPELLICON_205;
	        case 206:
	            return SPELLICON_206;
	        case 207:
	            return SPELLICON_207;
	        case 208:
	            return SPELLICON_208;
	        case 209:
	            return SPELLICON_209;
	        case 21:
	            return SPELLICON_21;
	        case 210:
	            return SPELLICON_210;
	        case 211:
	            return SPELLICON_211;
	        case 212:
	            return SPELLICON_212;
	        case 213:
	            return SPELLICON_213;
	        case 214:
	            return SPELLICON_214;
	        case 215:
	            return SPELLICON_215;
	        case 216:
	            return SPELLICON_216;
	        case 217:
	            return SPELLICON_217;
	        case 218:
	            return SPELLICON_218;
	        case 219:
	            return SPELLICON_219;
	        case 22:
	            return SPELLICON_22;
	        case 220:
	            return SPELLICON_220;
	        case 221:
	            return SPELLICON_221;
	        case 222:
	            return SPELLICON_222;
	        case 223:
	            return SPELLICON_223;
	        case 224:
	            return SPELLICON_224;
	        case 225:
	            return SPELLICON_225;
	        case 226:
	            return SPELLICON_226;
	        case 227:
	            return SPELLICON_227;
	        case 228:
	            return SPELLICON_228;
	        case 229:
	            return SPELLICON_229;
	        case 23:
	            return SPELLICON_23;
	        case 230:
	            return SPELLICON_230;
	        case 231:
	            return SPELLICON_231;
	        case 232:
	            return SPELLICON_232;
	        case 233:
	            return SPELLICON_233;
	        case 234:
	            return SPELLICON_234;
	        case 235:
	            return SPELLICON_235;
	        case 236:
	            return SPELLICON_236;
	        case 237:
	            return SPELLICON_237;
	        case 238:
	            return SPELLICON_238;
	        case 239:
	            return SPELLICON_239;
	        case 24:
	            return SPELLICON_24;
	        case 240:
	            return SPELLICON_240;
	        case 241:
	            return SPELLICON_241;
	        case 242:
	            return SPELLICON_242;
	        case 243:
	            return SPELLICON_243;
	        case 244:
	            return SPELLICON_244;
	        case 245:
	            return SPELLICON_245;
	        case 246:
	            return SPELLICON_246;
	        case 247:
	            return SPELLICON_247;
	        case 248:
	            return SPELLICON_248;
	        case 249:
	            return SPELLICON_249;
	        case 25:
	            return SPELLICON_25;
	        case 250:
	            return SPELLICON_250;
	        case 251:
	            return SPELLICON_251;
	        case 26:
	            return SPELLICON_26;
	        case 27:
	            return SPELLICON_27;
	        case 28:
	            return SPELLICON_28;
	        case 29:
	            return SPELLICON_29;
	        case 3:
	            return SPELLICON_3;
	        case 30:
	            return SPELLICON_30;
	        case 31:
	            return SPELLICON_31;
	        case 32:
	            return SPELLICON_32;
	        case 33:
	            return SPELLICON_33;
	        case 34:
	            return SPELLICON_34;
	        case 35:
	            return SPELLICON_35;
	        case 36:
	            return SPELLICON_36;
	        case 37:
	            return SPELLICON_37;
	        case 38:
	            return SPELLICON_38;
	        case 39:
	            return SPELLICON_39;
	        case 4:
	            return SPELLICON_4;
	        case 40:
	            return SPELLICON_40;
	        case 41:
	            return SPELLICON_41;
	        case 42:
	            return SPELLICON_42;
	        case 43:
	            return SPELLICON_43;
	        case 44:
	            return SPELLICON_44;
	        case 45:
	            return SPELLICON_45;
	        case 46:
	            return SPELLICON_46;
	        case 47:
	            return SPELLICON_47;
	        case 48:
	            return SPELLICON_48;
	        case 49:
	            return SPELLICON_49;
	        case 5:
	            return SPELLICON_5;
	        case 50:
	            return SPELLICON_50;
	        case 51:
	            return SPELLICON_51;
	        case 52:
	            return SPELLICON_52;
	        case 53:
	            return SPELLICON_53;
	        case 54:
	            return SPELLICON_54;
	        case 55:
	            return SPELLICON_55;
	        case 56:
	            return SPELLICON_56;
	        case 57:
	            return SPELLICON_57;
	        case 58:
	            return SPELLICON_58;
	        case 59:
	            return SPELLICON_59;
	        case 6:
	            return SPELLICON_6;
	        case 60:
	            return SPELLICON_60;
	        case 61:
	            return SPELLICON_61;
	        case 62:
	            return SPELLICON_62;
	        case 63:
	            return SPELLICON_63;
	        case 64:
	            return SPELLICON_64;
	        case 65:
	            return SPELLICON_65;
	        case 66:
	            return SPELLICON_66;
	        case 67:
	            return SPELLICON_67;
	        case 68:
	            return SPELLICON_68;
	        case 69:
	            return SPELLICON_69;
	        case 7:
	            return SPELLICON_7;
	        case 70:
	            return SPELLICON_70;
	        case 71:
	            return SPELLICON_71;
	        case 72:
	            return SPELLICON_72;
	        case 73:
	            return SPELLICON_73;
	        case 74:
	            return SPELLICON_74;
	        case 75:
	            return SPELLICON_75;
	        case 76:
	            return SPELLICON_76;
	        case 77:
	            return SPELLICON_77;
	        case 78:
	            return SPELLICON_78;
	        case 79:
	            return SPELLICON_79;
	        case 8:
	            return SPELLICON_8;
	        case 80:
	            return SPELLICON_80;
	        case 81:
	            return SPELLICON_81;
	        case 82:
	            return SPELLICON_82;
	        case 83:
	            return SPELLICON_83;
	        case 84:
	            return SPELLICON_84;
	        case 85:
	            return SPELLICON_85;
	        case 86:
	            return SPELLICON_86;
	        case 87:
	            return SPELLICON_87;
	        case 88:
	            return SPELLICON_88;
	        case 89:
	            return SPELLICON_89;
	        case 9:
	            return SPELLICON_9;
	        case 90:
	            return SPELLICON_90;
	        case 91:
	            return SPELLICON_91;
	        case 92:
	            return SPELLICON_92;
	        case 93:
	            return SPELLICON_93;
	        case 94:
	            return SPELLICON_94;
	        case 95:
	            return SPELLICON_95;
	        case 96:
	            return SPELLICON_96;
	        case 97:
	            return SPELLICON_97;
	        case 98:
	            return SPELLICON_98;
	        case 99:
	            return SPELLICON_99;
	        default:
	        return null;

	    }
	}

}
