package xyz.leiwang.bandoumovie.mapper;

import java.util.List;

import xyz.leiwang.bandoumovie.po.Remark;


/**
* @author Lei Wang
* @email ileiwang@live.com
* @blog ileiwang.cc
* @date 2019-07-09 10:54:09
*/
public interface RemarkMapper {
	
	// ��������ɾ��
    int deleteByPrimaryKey(Integer rid);

    // ����ȫ����
    int insert(Remark remark);
    
    // ���벿����
    int insertSelective(Remark remark);
    
    // ����
    int updateRemark(Remark remark);

    // ͳ��ȫ����������
	int countAllRemark();

	// ��ҳ��ѯ�����б�
	List<Remark> findRemarkByPage(int page, int limitPage);
	
	// ����Ӱ��ѯ�����б�
	List<Remark> findRemarkByMid(int mid);
	
	// ���û���ѯ�����б�
	List<Remark> findRemarkByUid(int uid);
	
	// ��������ѯ����
	Remark findRemarkByPrimaryKey(int rid);
	
	
	List<Remark> findAllRemark();

}
