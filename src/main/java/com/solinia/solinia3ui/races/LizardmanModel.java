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
		textureWidth = 128;
		textureHeight = 128;

		rightleg = new RendererModel(this);
		rightleg.setRotationPoint(0.0F, 24.0F, 0.0F);
		rightleg.cubeList.add(new ModelBox(rightleg, 48, 0, 0.7F, -2.2F, 0.7F, 4, 2, 6, 0.0F, false));

		bone = new RendererModel(this);
		bone.setRotationPoint(-1.0F, 0.0F, 0.0F);
		setRotationAngle(bone, 1.309F, 0.0F, 0.0F);
		rightleg.addChild(bone);
		bone.cubeList.add(new ModelBox(bone, 44, 14, 2.8F, 3.1435F, 2.2276F, 2, 2, 8, 0.0F, false));

		bone3 = new RendererModel(this);
		bone3.setRotationPoint(-0.7F, -2.2F, -1.2F);
		setRotationAngle(bone3, 1.309F, 0.0F, 0.0F);
		rightleg.addChild(bone3);
		bone3.cubeList.add(new ModelBox(bone3, 0, 34, 1.6F, -2.2295F, 8.139F, 4, 4, 8, 0.0F, false));

		bone2 = new RendererModel(this);
		bone2.setRotationPoint(-1.0F, 0.75F, 1.25F);
		setRotationAngle(bone2, 2.5307F, 0.0F, 0.0F);
		rightleg.addChild(bone2);
		bone2.cubeList.add(new ModelBox(bone2, 46, 54, 3.0F, 9.4655F, 0.1871F, 2, 2, 6, 0.0F, false));

		leftleg = new RendererModel(this);
		leftleg.setRotationPoint(0.0F, 24.0F, 0.0F);
		leftleg.cubeList.add(new ModelBox(leftleg, 0, 46, -5.3F, -2.2F, 0.7F, 4, 2, 6, 0.0F, false));

		bone4 = new RendererModel(this);
		bone4.setRotationPoint(-4.0F, 0.0F, 0.0F);
		setRotationAngle(bone4, 1.309F, 0.0F, 0.0F);
		leftleg.addChild(bone4);
		bone4.cubeList.add(new ModelBox(bone4, 36, 42, -0.2F, 3.1435F, 2.2276F, 2, 2, 8, 0.0F, false));

		bone5 = new RendererModel(this);
		bone5.setRotationPoint(-3.7F, -2.2F, -1.2F);
		setRotationAngle(bone5, 1.309F, 0.0F, 0.0F);
		leftleg.addChild(bone5);
		bone5.cubeList.add(new ModelBox(bone5, 32, 0, -1.4F, -2.2295F, 8.139F, 4, 4, 8, 0.0F, false));

		bone6 = new RendererModel(this);
		bone6.setRotationPoint(-4.0F, 0.75F, 1.25F);
		setRotationAngle(bone6, 2.5307F, 0.0F, 0.0F);
		leftleg.addChild(bone6);
		bone6.cubeList.add(new ModelBox(bone6, 0, 54, -0.2F, 9.4655F, 0.1871F, 2, 2, 6, 0.0F, false));

		body = new RendererModel(this);
		body.setRotationPoint(-1.0F, 20.0F, 1.0F);
		setRotationAngle(body, -0.3491F, 0.0F, 0.0F);
		body.cubeList.add(new ModelBox(body, 28, 28, -3.3F, -21.5176F, -4.4362F, 8, 10, 4, 0.0F, false));

		bone7 = new RendererModel(this);
		bone7.setRotationPoint(0.0F, 0.0F, -2.0F);
		setRotationAngle(bone7, 0.5236F, 0.0F, 0.0F);
		body.addChild(bone7);
		bone7.cubeList.add(new ModelBox(bone7, 0, 0, -4.4F, -25.6566F, 6.713F, 10, 8, 6, 0.0F, false));

		tail = new RendererModel(this);
		tail.setRotationPoint(-1.0F, 17.3109F, -0.288F);
		setRotationAngle(tail, 1.0472F, 0.0F, 0.0F);
		tail.cubeList.add(new ModelBox(tail, 20, 50, -2.3F, -4.2789F, 7.9822F, 6, 8, 2, 0.0F, false));

		bone8 = new RendererModel(this);
		bone8.setRotationPoint(0.0F, 2.3891F, -1.712F);
		setRotationAngle(bone8, 0.7854F, 0.0F, 0.0F);
		tail.addChild(bone8);
		bone8.cubeList.add(new ModelBox(bone8, 58, 32, -1.4F, 8.0318F, 5.9921F, 4, 8, 2, 0.0F, false));

		bone9 = new RendererModel(this);
		bone9.setRotationPoint(0.0F, 2.3891F, -1.712F);
		setRotationAngle(bone9, 1.309F, 0.0F, 0.0F);
		tail.addChild(bone9);
		bone9.cubeList.add(new ModelBox(bone9, 62, 42, -0.5F, 16.7319F, -2.6999F, 2, 8, 2, 0.0F, false));

		rightarm = new RendererModel(this);
		rightarm.setRotationPoint(0.5F, 22.4F, 0.3F);
		setRotationAngle(rightarm, 0.0F, 0.0F, -0.5236F);
		rightarm.cubeList.add(new ModelBox(rightarm, 44, 62, 16.15F, -23.5282F, 1.8F, 2, 8, 2, 0.0F, false));

		bone10 = new RendererModel(this);
		bone10.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(bone10, 0.6109F, 0.0F, 0.0F);
		rightarm.addChild(bone10);
		bone10.cubeList.add(new ModelBox(bone10, 50, 46, 16.15F, -12.64F, 5.903F, 2, 2, 6, 0.0F, false));
		bone10.cubeList.add(new ModelBox(bone10, 36, 52, 15.15F, -13.84F, 2.903F, 4, 4, 4, 0.0F, false));

		leftarm = new RendererModel(this);
		leftarm.setRotationPoint(-0.7F, 22.4F, 0.3F);
		setRotationAngle(leftarm, 0.0F, 0.0F, 0.5236F);
		leftarm.cubeList.add(new ModelBox(leftarm, 0, 62, -18.9F, -23.2782F, 1.8F, 2, 8, 2, 0.0F, false));

		bone11 = new RendererModel(this);
		bone11.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(bone11, 0.6109F, 0.0F, 0.0F);
		leftarm.addChild(bone11);
		bone11.cubeList.add(new ModelBox(bone11, 48, 36, -18.9F, -12.797F, 6.0126F, 2, 2, 6, 0.0F, false));
		bone11.cubeList.add(new ModelBox(bone11, 48, 24, -19.9F, -13.997F, 3.0126F, 4, 4, 4, 0.0F, false));

		head = new RendererModel(this);
		head.setRotationPoint(0.0F, 21.7F, -0.1F);
		setRotationAngle(head, -0.6981F, 0.0F, 0.0F);
		head.cubeList.add(new ModelBox(head, 0, 24, -4.2F, -26.753F, -19.0728F, 8, 4, 6, 0.0F, false));

		bone12 = new RendererModel(this);
		bone12.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(bone12, 0.5236F, 0.0F, 0.0F);
		head.addChild(bone12);
		bone12.cubeList.add(new ModelBox(bone12, 20, 42, -4.2F, -33.1368F, -7.3196F, 8, 4, 4, 0.0F, false));
		bone12.cubeList.add(new ModelBox(bone12, 0, 14, -4.2F, -33.1368F, -15.3196F, 8, 2, 8, 0.0F, false));
		bone12.cubeList.add(new ModelBox(bone12, 58, 60, 1.2F, -36.092F, -11.0716F, 2, 2, 4, 0.0F, false));
		bone12.cubeList.add(new ModelBox(bone12, 56, 14, -2.8F, -35.5996F, -11.0848F, 4, 2, 4, 0.0F, false));
		bone12.cubeList.add(new ModelBox(bone12, 32, 60, -3.8F, -36.092F, -11.0716F, 2, 2, 4, 0.0F, false));
		bone12.cubeList.add(new ModelBox(bone12, 0, 12, -3.4F, -34.2378F, -11.2624F, 0, 2, 4, 0.0F, false));
		bone12.cubeList.add(new ModelBox(bone12, 0, 10, 2.0F, -34.2378F, -11.2624F, 0, 2, 4, 0.0F, false));

		tongue = new RendererModel(this);
		tongue.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone12.addChild(tongue);
		tongue.cubeList.add(new ModelBox(tongue, 20, 0, -2.2F, -30.3F, -13.1F, 4, 0, 6, 0.0F, false));

		lowerjaw = new RendererModel(this);
		lowerjaw.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone12.addChild(lowerjaw);
		lowerjaw.cubeList.add(new ModelBox(lowerjaw, 24, 14, -4.2F, -31.1368F, -13.3196F, 8, 2, 6, 0.0F, false));

		bone13 = new RendererModel(this);
		bone13.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(bone13, -0.7854F, 0.0F, 0.0F);
		bone12.addChild(bone13);
		bone13.cubeList.add(new ModelBox(bone13, 20, 60, -3.6F, -20.4458F, -30.4978F, 2, 2, 4, 0.0F, false));
		bone13.cubeList.add(new ModelBox(bone13, 12, 58, 1.0F, -20.4458F, -30.4978F, 2, 2, 4, 0.0F, false));
		bone13.cubeList.add(new ModelBox(bone13, 52, 8, -3.0F, -20.159F, -30.0882F, 4, 2, 4, 0.0F, false));

		bone14 = new RendererModel(this);
		bone14.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(bone14, 0.7854F, 0.0F, 0.0F);
		bone12.addChild(bone14);
		bone14.cubeList.add(new ModelBox(bone14, 56, 54, -3.6F, -33.2456F, 13.7435F, 2, 2, 4, 0.0F, false));
		bone14.cubeList.add(new ModelBox(bone14, 16, 34, 1.0F, -33.2456F, 13.7435F, 2, 2, 4, 0.0F, false));
		bone14.cubeList.add(new ModelBox(bone14, 28, 22, -3.0F, -32.836F, 13.4567F, 4, 2, 4, 0.0F, false));
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