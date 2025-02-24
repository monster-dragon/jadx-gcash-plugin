package jadx.plugins.example;

import jadx.api.data.CommentStyle;
import jadx.api.plugins.pass.JadxPassInfo;
import jadx.api.plugins.pass.impl.OrderedJadxPassInfo;
import jadx.api.plugins.pass.types.JadxDecompilePass;
import jadx.core.Jadx;
import jadx.core.dex.nodes.ClassNode;
import jadx.core.dex.nodes.MethodNode;
import jadx.core.dex.nodes.RootNode;

public class AddCommentPass implements JadxDecompilePass {

	private String comment;

	@Override
	public JadxPassInfo getInfo() {
		return new OrderedJadxPassInfo(
				"AddComment",
				"Add comment for every class")
				.before("RegionMakerVisitor");
	}

	@Override
	public void init(RootNode root) {
		this.comment = "Class generated by jadx decompiler (" + Jadx.getVersion() + ")";
	}

	@Override
	public boolean visit(ClassNode cls) {
		cls.addCodeComment(comment, CommentStyle.BLOCK);
		return false;
	}

	@Override
	public void visit(MethodNode mth) {
	}
}
