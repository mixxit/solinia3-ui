package com.solinia.solinia3ui.races;

import net.minecraft.client.renderer.model.ModelBox;
import net.minecraft.entity.monster.RavagerEntity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;

public class LizardmanModel extends EntityModel<LizardmanEntity> {
	private final RendererModel rightleg;
	private final RendererModel bone;
	private final RendererModel bone3;
	private final RendererModel bone2;
	private final RendererModel leftleg;
	private final RendererModel bone4;
	private final RendererModel bone5;
	private final RendererModel bone6;
	private final RendererModel body;
	private final RendererModel bone7;
	private final RendererModel tail;
	private final RendererModel bone8;
	private final RendererModel bone9;
	private final RendererModel rightarm;
	private final RendererModel bone10;
	private final RendererModel leftarm;
	private final RendererModel bone11;
	private final RendererModel head;
	private final RendererModel bone12;
	private final RendererModel tongue;
	private final RendererModel lowerjaw;
	private final RendererModel bone13;
	private final RendererModel bone14;

	public LizardmanModel() {
		textureWidth = 64;
		textureHeight = 64;

		rightleg = new RendererModel(this);
		rightleg.setRotationPoint(0.0F, 24.0F, 0.0F);
		rightleg.cubeList.add(new ModelBox(rightleg, 24, 0, 0.3F, -1.1F, -0.5F, 2, 1, 3, 0.0F, false));

		bone = new RendererModel(this);
		bone.setRotationPoint(-1.0F, 0.0F, 0.0F);
		setRotationAngle(bone, 1.309F, 0.0F, 0.0F);
		rightleg.addChild(bone);
		bone.cubeList.add(new ModelBox(bone, 22, 7, 1.85F, 0.7507F, 0.8938F, 1, 1, 4, 0.0F, false));

		bone3 = new RendererModel(this);
		bone3.setRotationPoint(-0.7F, -2.2F, -1.2F);
		setRotationAngle(bone3, 1.309F, 0.0F, 0.0F);
		rightleg.addChild(bone3);
		bone3.cubeList.add(new ModelBox(bone3, 0, 17, 1.15F, -0.8358F, 2.9495F, 2, 2, 4, 0.0F, false));

		bone2 = new RendererModel(this);
		bone2.setRotationPoint(-1.0F, 0.75F, 1.25F);
		setRotationAngle(bone2, 2.5307F, 0.0F, 0.0F);
		rightleg.addChild(bone2);
		bone2.cubeList.add(new ModelBox(bone2, 23, 27, 1.9F, 4.2702F, 1.3148F, 1, 1, 3, 0.0F, false));

		leftleg = new RendererModel(this);
		leftleg.setRotationPoint(0.0F, 24.0F, 0.0F);
		leftleg.cubeList.add(new ModelBox(leftleg, 0, 23, -2.7F, -1.1F, -0.5F, 2, 1, 3, 0.0F, false));

		bone4 = new RendererModel(this);
		bone4.setRotationPoint(-4.0F, 0.0F, 0.0F);
		setRotationAngle(bone4, 1.309F, 0.0F, 0.0F);
		leftleg.addChild(bone4);
		bone4.cubeList.add(new ModelBox(bone4, 18, 21, 1.85F, 0.7507F, 0.8938F, 1, 1, 4, 0.0F, false));

		bone5 = new RendererModel(this);
		bone5.setRotationPoint(-3.7F, -2.2F, -1.2F);
		setRotationAngle(bone5, 1.309F, 0.0F, 0.0F);
		leftleg.addChild(bone5);
		bone5.cubeList.add(new ModelBox(bone5, 16, 0, 1.15F, -0.8358F, 2.9495F, 2, 2, 4, 0.0F, false));

		bone6 = new RendererModel(this);
		bone6.setRotationPoint(-4.0F, 0.75F, 1.25F);
		setRotationAngle(bone6, 2.5307F, 0.0F, 0.0F);
		leftleg.addChild(bone6);
		bone6.cubeList.add(new ModelBox(bone6, 0, 27, 1.9F, 4.2702F, 1.3148F, 1, 1, 3, 0.0F, false));

		body = new RendererModel(this);
		body.setRotationPoint(-1.0F, 20.0F, 1.0F);
		setRotationAngle(body, -0.3491F, 0.0F, 0.0F);
		body.cubeList.add(new ModelBox(body, 14, 14, -1.15F, -8.7588F, -2.7181F, 4, 5, 2, 0.0F, false));

		bone7 = new RendererModel(this);
		bone7.setRotationPoint(0.0F, 0.0F, -2.0F);
		setRotationAngle(bone7, 0.5236F, 0.0F, 0.0F);
		body.addChild(bone7);
		bone7.cubeList.add(new ModelBox(bone7, 0, 0, -1.7F, -10.8283F, 2.8565F, 5, 4, 3, 0.0F, false));

		tail = new RendererModel(this);
		tail.setRotationPoint(-1.0F, 17.3109F, -0.288F);
		setRotationAngle(tail, 1.0472F, 0.0F, 0.0F);
		tail.cubeList.add(new ModelBox(tail, 10, 25, -0.65F, 0.9551F, 2.2021F, 3, 4, 1, 0.0F, false));

		bone8 = new RendererModel(this);
		bone8.setRotationPoint(0.0F, 2.3891F, -1.712F);
		setRotationAngle(bone8, 0.7854F, 0.0F, 0.0F);
		tail.addChild(bone8);
		bone8.cubeList.add(new ModelBox(bone8, 29, 16, -0.2F, 4.5365F, 1.0131F, 2, 4, 1, 0.0F, false));

		bone9 = new RendererModel(this);
		bone9.setRotationPoint(0.0F, 2.3891F, -1.712F);
		setRotationAngle(bone9, 1.309F, 0.0F, 0.0F);
		tail.addChild(bone9);
		bone9.cubeList.add(new ModelBox(bone9, 22, 31, 0.25F, 8.0374F, -3.4035F, 1, 4, 1, 0.0F, false));

		rightarm = new RendererModel(this);
		rightarm.setRotationPoint(0.5F, 22.4F, 0.3F);
		setRotationAngle(rightarm, 0.0F, 0.0F, -0.5236F);
		rightarm.cubeList.add(new ModelBox(rightarm, 0, 31, 7.45F, -11.2141F, 0.75F, 1, 4, 1, 0.0F, false));

		bone10 = new RendererModel(this);
		bone10.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(bone10, 0.6109F, 0.0F, 0.0F);
		rightarm.addChild(bone10);
		bone10.cubeList.add(new ModelBox(bone10, 25, 23, 7.4F, -5.9248F, 2.4449F, 1, 1, 3, 0.0F, false));
		bone10.cubeList.add(new ModelBox(bone10, 18, 26, 6.8F, -6.5248F, 0.9449F, 2, 2, 2, 0.0F, false));

		leftarm = new RendererModel(this);
		leftarm.setRotationPoint(-0.7F, 22.4F, 0.3F);
		setRotationAngle(leftarm, 0.0F, 0.0F, 0.5236F);
		leftarm.cubeList.add(new ModelBox(leftarm, 30, 30, -8.45F, -11.2141F, 0.75F, 1, 4, 1, 0.0F, false));

		bone11 = new RendererModel(this);
		bone11.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(bone11, 0.6109F, 0.0F, 0.0F);
		leftarm.addChild(bone11);
		bone11.cubeList.add(new ModelBox(bone11, 24, 18, -8.45F, -5.9057F, 2.5714F, 1, 1, 3, 0.0F, false));
		bone11.cubeList.add(new ModelBox(bone11, 24, 12, -9.0F, -6.5057F, 1.0714F, 2, 2, 2, 0.0F, false));

		head = new RendererModel(this);
		head.setRotationPoint(0.0F, 21.7F, -0.1F);
		setRotationAngle(head, -0.6981F, 0.0F, 0.0F);
		head.cubeList.add(new ModelBox(head, 0, 12, -2.1F, -12.2265F, -9.4864F, 4, 2, 3, 0.0F, false));

		bone12 = new RendererModel(this);
		bone12.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(bone12, 0.5236F, 0.0F, 0.0F);
		head.addChild(bone12);
		bone12.cubeList.add(new ModelBox(bone12, 10, 21, -2.0F, -15.3316F, -4.1022F, 4, 2, 2, 0.0F, false));
		bone12.cubeList.add(new ModelBox(bone12, 0, 7, -2.0F, -15.3316F, -8.1022F, 4, 1, 4, 0.0F, false));
		bone12.cubeList.add(new ModelBox(bone12, 16, 30, 0.7F, -16.8092F, -5.8782F, 1, 1, 2, 0.0F, false));
		bone12.cubeList.add(new ModelBox(bone12, 30, 12, -1.3F, -16.563F, -5.7348F, 2, 1, 2, 0.0F, false));
		bone12.cubeList.add(new ModelBox(bone12, 10, 30, -1.8F, -16.8092F, -5.8782F, 1, 1, 2, 0.0F, false));
		bone12.cubeList.add(new ModelBox(bone12, 0, 6, -1.6F, -15.8439F, -5.5812F, 0, 1, 2, 0.0F, false));
		bone12.cubeList.add(new ModelBox(bone12, 0, 5, 1.1F, -15.8439F, -5.5812F, 0, 1, 2, 0.0F, false));

		tongue = new RendererModel(this);
		tongue.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone12.addChild(tongue);
		tongue.cubeList.add(new ModelBox(tongue, 10, 0, -1.0F, -14.0F, -7.0F, 2, 0, 3, 0.0F, false));

		lowerjaw = new RendererModel(this);
		lowerjaw.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone12.addChild(lowerjaw);
		lowerjaw.cubeList.add(new ModelBox(lowerjaw, 12, 7, -2.0F, -14.3316F, -7.1022F, 4, 1, 3, 0.0F, false));

		bone13 = new RendererModel(this);
		bone13.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(bone13, -0.7854F, 0.0F, 0.0F);
		bone12.addChild(bone13);
		bone13.cubeList.add(new ModelBox(bone13, 6, 29, -1.7F, -9.0729F, -14.6989F, 1, 1, 2, 0.0F, false));
		bone13.cubeList.add(new ModelBox(bone13, 28, 27, 0.6F, -9.0729F, -14.6989F, 1, 1, 2, 0.0F, false));
		bone13.cubeList.add(new ModelBox(bone13, 26, 4, -1.4F, -8.9295F, -14.4941F, 2, 1, 2, 0.0F, false));

		bone14 = new RendererModel(this);
		bone14.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(bone14, 0.7854F, 0.0F, 0.0F);
		bone12.addChild(bone14);
		bone14.cubeList.add(new ModelBox(bone14, 28, 7, -1.7F, -15.7596F, 5.5122F, 1, 1, 2, 0.0F, false));
		bone14.cubeList.add(new ModelBox(bone14, 8, 17, 0.6F, -15.7596F, 5.5122F, 1, 1, 2, 0.0F, false));
		bone14.cubeList.add(new ModelBox(bone14, 14, 11, -1.4F, -15.5548F, 5.8688F, 2, 1, 2, 0.0F, false));
	}

	@Override
	public void render(LizardmanEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		this.setRotationAngles(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		rightleg.render(scale);
		leftleg.render(scale);
		body.render(scale);
		tail.render(scale);
		rightarm.render(scale);
		leftarm.render(scale);
		head.render(scale);
	}
	
	public void setLivingAnimations(LizardmanEntity entityIn, float limbSwing, float limbSwingAmount, float partialTick) {
		super.setLivingAnimations(entityIn, limbSwing, limbSwingAmount, partialTick);
		//head.rotateAngleZ += 0.01;
	}
	
	public void setRotationAngle(RendererModel RendererModel, float x, float y, float z) {
		RendererModel.rotateAngleX = x;
		RendererModel.rotateAngleY = y;
		RendererModel.rotateAngleZ = z;
	}
}