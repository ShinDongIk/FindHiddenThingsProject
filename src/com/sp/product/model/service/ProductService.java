package com.sp.product.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.sp.product.model.dao.ProductDao;
import com.sp.product.model.vo.PageInfo;
import com.sp.product.model.vo.PickList;
import com.sp.product.model.vo.Product;
import com.sp.product.model.vo.ProductDetail;
import com.sp.product.model.vo.ProductFile;
import com.sp.product.model.vo.Report;

import static com.sp.common.JDBCTemplate.*;

public class ProductService {

	public ArrayList<Product> productSelectList(String category, PageInfo page) {
		Connection conn = connect();
		
		ArrayList<Product> list = new ProductDao().productSelectList(conn,category,page);
		
		close(conn);
		
		return list;
	}

	public PickList productPickSelect(int productNo, String nickName) {
		Connection conn = connect();
		
		PickList pk =new ProductDao().productPickSelect(conn,productNo,nickName);
		
		close(conn);
		
		return pk;
	}

	public int productPickInsert(int productNo, String nickName) {
		Connection conn = connect();
		
		int result = new ProductDao().productPickInsert(conn,productNo,nickName);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public int productPickDelete(PickList pk) {
		Connection conn = connect();
		
		int result = new ProductDao().productPickDelete(conn,pk);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public ArrayList<PickList> productPickLoad(int userNo) {
		Connection conn = connect();
		
		ArrayList<PickList> list = new ProductDao().productPickLoad(conn,userNo);
		
		close(conn);
		
		return list;
	}

	public int productListCount(String category) {
		Connection conn = connect();
		
		int count = new ProductDao().productListCount(conn,category);
		
		close(conn);
		
		return count;
	}
	
	//조회수 증가 DAO
		public int increaseCount(int productNo) {
			
			Connection conn = connect();
			
			int result = new ProductDao().increaseCount(conn,productNo);
			
			
			if(result>0) {
				commit(conn);
			}else {
				rollback(conn);
			}
			close(conn);
			
			return result;
			
		}
		
		//물품 상세보기 데이터 가져오는 DAO
		public ProductDetail selectProduct(int productNo) {
			
			Connection conn = connect();
			
			ProductDetail p = new ProductDao().selectProduct(conn,productNo);
			
			close(conn);
			
			return p;
		}
		//물품 상세보기 사진 가져오는 DAO
		public ArrayList<ProductFile> selectAttachmentList(int productNo) {
			
			Connection conn = connect();
			
			ArrayList<ProductFile> list = new ProductDao().selectAttacgmentList(conn,productNo);
			
			close(conn);
			
			return list;
			
		}

		public int productPickDeleteUpdate(int productNo) {
			Connection conn = connect();
			
			int result = new ProductDao().productPickDeleteUpdate(conn,productNo);
			
			if(result>0) {
				commit(conn);
			}else {
				rollback(conn);
			}
			
			close(conn);
			
			return result;
		}

		public int productPickAddUpdate(int productNo) {
			Connection conn = connect();
			
			int result = new ProductDao().productPickAddUpdate(conn,productNo);
			
			if(result>0) {
				commit(conn);
			}else {
				rollback(conn);
			}
			
			close(conn);
			
			return result;
		}

		public boolean amIPcik(int productNo, int userNo) {
			Connection conn = connect();
			
			boolean pick = new ProductDao().amIPcik(conn,productNo,userNo);
			
			close(conn);
			
			return pick;
		}

		public int productPickCount(int productNo) {
			Connection conn = connect();
			
			int pickCount = new ProductDao().productPickCount(conn,productNo);
			
			close(conn);
			
			return pickCount;
		}

		public ArrayList<Product> mainProductSelectList(String category) {
			Connection conn = connect();
			
			ArrayList<Product> list = new ProductDao().productSelectList(conn,category);
			
			close(conn);
			
			return list;
		}

		public int productSell(int productNo) {
			Connection conn = connect();
			
			int result = new ProductDao().productSell(conn,productNo);
			
			if(result>0) {
				commit(conn);
			}else {
				rollback(conn);
			}
			
			close(conn);
			
			return result;
		}

		public int productBuy(int productNo, int userNo) {
			Connection conn = connect();
			
			int result = new ProductDao().productBuy(conn,productNo,userNo);
			
			if(result>0) {
				commit(conn);
			}else {
				rollback(conn);
			}
			
			close(conn);
			
			return result;
		}

		public int searchProduct(int productNo, int buyUserNo) {
			Connection conn = connect();

			int userNo = new ProductDao().searchProduct(conn,productNo,buyUserNo);
			
			close(conn);
			
			return userNo;
		}
		
		public int insertProduct(Product p, ArrayList<ProductFile> list) {
			
			Connection conn = connect();
			
			int result1 = new ProductDao().insertProduct(conn,p);
			int result2 = new ProductDao().insertProductFile(conn,list);
			
			if(result1>0 && result2>0){
				commit(conn);
			}else {
				rollback(conn);
			}
			close(conn);
			
			return result1 * result2;
		}

		public int updateProduct(ProductDetail pd, ProductFile pf) {
			Connection conn = connect();
			
			int result = new ProductDao().updateProduct(conn,pd,pf);
			
			if(result>0) {
				commit(conn);
			}else{
				rollback(conn);
			}
			
			return result;
		}

		public int productDelete(int productNo) {
			Connection conn = connect();
			
			int result = new ProductDao().productDelete(conn,productNo);
			
			if(result>0) {
				result = new ProductDao().productFileDelete(conn,productNo);
				if(result > 0) {
					commit(conn);
				}else {
					rollback(conn);
				}
			}else {
				rollback(conn);
			}
			
			return result;
		}
		
		public int menubarSearchCount(String keyword) {
            Connection conn = connect();

            int count = new ProductDao().menubarSearchCount(conn,keyword);

            close(conn);

            return count;
        }
        public ArrayList<Product> menubarSearchList(String keyword, PageInfo page) {
            Connection conn = connect();

            ArrayList<Product> list = new ProductDao().menubarSearchList(conn,keyword,page);

            close(conn);

            return list;
        }

        public ArrayList<Product> pickSelectList(int userNo, PageInfo pi) {
    		
    		Connection conn = connect();
    		
    		ArrayList<Product> list = new ProductDao().pickSelectList(conn,userNo,pi);
    		
    		close(conn);
    		
    		return list;
    	}

    	public int productPickListCount(int userNo) {
    		
    		Connection conn = connect();
    		
    		int result = new ProductDao().productPickListCount(conn,userNo);
    		
    		close(conn);
    		
    		return  result;
    	}

		public int productSubListCount(String category, String subKeyword) {
			Connection conn = connect();
			
			int count = new ProductDao().productSubListCount(conn,category,subKeyword);
			
			close(conn);
			
			return count;
		}

		public ArrayList<Product> productSelectSubList(String category, String categorySub, PageInfo page, String subKeyword) {
			Connection conn = connect();
			
			ArrayList<Product> list = new ProductDao().productSelectSubList(conn,category,categorySub,subKeyword,page);
			
			close(conn);
			
			return list;
		}

		public int purchaseListCount(int userNo) {
			Connection conn = connect();
			
			int result = new ProductDao().purchaseListCount(conn,userNo);
			
			close(conn);
			
			return result;
		}

		public ArrayList<Product> purchaseList(int userNo, PageInfo pi) {
			Connection conn = connect();
			
			ArrayList<Product> list = new ProductDao().purchaseList(conn,userNo,pi);
			
			close(conn);
			
			return list;
			
		}

		public ArrayList<Product> purchaseFileName(int userNo) {
			Connection conn = connect();
			
			ArrayList<Product> list2 = new ProductDao().purchaseFileName(conn,userNo);
			
			close(conn);
			
			return list2;
			
		}

		public ArrayList<Product> productMainList(String category) {
			Connection conn = connect();
			
			ArrayList<Product> list = new ProductDao().productMainList(conn,category);
			
			close(conn);
			
			return list;
		}
		
		public int insertReport(Report r) {
			Connection conn = connect();
			
			int result = new ProductDao().insertReport(conn,r);
			
			if(result>0) {
				commit(conn);
			}else {
				rollback(conn);
			}
			close(conn);
			
			return result;
		}

		public int reportListCount() {
			Connection conn = connect();
			
			int result = new ProductDao().reportListCount(conn);
			
			close(conn);
			
			return result;
		}

		public ArrayList<Report> reportList(PageInfo pi) {
			Connection conn = connect();
			
			ArrayList<Report> list = new ProductDao().reportList(conn,pi);
			
			close(conn);
			
			return list;
			
		}

		public Report reportDetailView(int reportNo) {
			Connection conn = connect();
			
			Report r = new ProductDao().reportDetailView(conn,reportNo);
			
			close(conn);
			
			return r;
			
		}
}
