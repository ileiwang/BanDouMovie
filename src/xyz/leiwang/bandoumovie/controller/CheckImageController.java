package xyz.leiwang.bandoumovie.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
* @author Lei Wang
* @email ileiwang@live.com
* @blog ileiwang.cc
* @date 2019-07-09 10:41:23
*/
@Controller
public class CheckImageController {
	
	// ������֤��
	@RequestMapping("checkImg")
	public void checkImg(HttpServletRequest request ,HttpServletResponse response) throws IOException {

		int width = 120;
		int height = 30;

		// ����һ ����һ���ڴ���ͼƬ
		BufferedImage bufferedImage = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);

		// ����� ͼƬ���Ʊ�����ɫ ---ͨ����ͼ����
		Graphics graphics = bufferedImage.getGraphics();// �õ���ͼ���� --- ����
		// �����κ�ͼ��֮ǰ ������ָ��һ����ɫ
		graphics.setColor(getRandColor(200, 250));
		graphics.fillRect(0, 0, width, height);

		// ������ ���Ʊ߿�
		graphics.setColor(Color.WHITE);
		graphics.drawRect(0, 0, width - 1, height - 1);

		// ������ �ĸ��������
		Graphics2D graphics2d = (Graphics2D) graphics;
		// �����������
		graphics2d.setFont(new Font("����", Font.BOLD, 18));

		// String words
		// ="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
		String words = "\u7684\u4e00\u4e86\u662f\u6211\u4e0d\u5728\u4eba\u4eec\u6709\u6765\u4ed6\u8fd9\u4e0a\u7740\u4e2a\u5730\u5230\u5927\u91cc\u8bf4\u5c31\u53bb\u5b50\u5f97\u4e5f\u548c\u90a3\u8981\u4e0b\u770b\u5929\u65f6\u8fc7\u51fa\u5c0f\u4e48\u8d77\u4f60\u90fd\u628a\u597d\u8fd8";
		Random random = new Random();// ���������
		// ����StringBuffer
		StringBuffer sb = new StringBuffer();
		// ����x����
		int x = 10;
		for (int i = 0; i < 4; i++) {
			// �����ɫ
			graphics2d.setColor(new Color(20 + random.nextInt(110), 20 + random
					.nextInt(110), 20 + random.nextInt(110)));
			// ��ת -30 --- 30��
			int jiaodu = random.nextInt(60) - 30;
			// ���㻡��
			double theta = jiaodu * Math.PI / 180;

			// ����һ���������
			int index = random.nextInt(words.length()); // ��������� 0 �� length - 1
			// �����ĸ����
			char c = words.charAt(index);
			sb.append(c);
			// ��c �����ͼƬ
			graphics2d.rotate(theta, x, 20);
			graphics2d.drawString(String.valueOf(c), x, 20);
			graphics2d.rotate(-theta, x, 20);
			x += 30;
		}

		// �����ɵ���ĸ���뵽session��
		request.getSession().setAttribute("checkcode", sb.toString());
		System.out.println(sb.toString());
		// ������ ���Ƹ�����
		graphics.setColor(getRandColor(160, 200));
		int x1;
		int x2;
		int y1;
		int y2;
		for (int i = 0; i < 30; i++) {
			x1 = random.nextInt(width);
			x2 = random.nextInt(12);
			y1 = random.nextInt(height);
			y2 = random.nextInt(12);
			graphics.drawLine(x1, y1, x1 + x2, x2 + y2);
		}

		// ������ͼƬ���������� ImageIO
		graphics.dispose();// �ͷ���Դ
		ImageIO.write(bufferedImage, "jpg", response.getOutputStream());
	}

	private Color getRandColor(int fc, int bc) {
		// ȡ�������ɫ
		Random random = new Random();
		if (fc > 255) {
			fc = 255;
		}
		if (bc > 255) {
			bc = 255;
		}
		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		return new Color(r, g, b);
	}

}
