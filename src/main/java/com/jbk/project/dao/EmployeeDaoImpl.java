package com.jbk.project.dao;


import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.project.entity.Country;
import com.jbk.project.entity.Employee;
import com.jbk.project.entity.Registration;



@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	
	@Autowired
	SessionFactory sessionFactory;
	Session session;
	Transaction transaction ;
	
	@Override
	public Registration checkLogin(String email, String password) {
		Registration user =null;
		try {
			session =sessionFactory.openSession();
			Criteria criteria =session.createCriteria(Registration.class);
			criteria.add(Restrictions.eq("email", email));
			criteria.add(Restrictions.eq("password", password));
			
			 user =(Registration) criteria.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
	

	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> list = null;
		try {
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Employee.class);
			list = criteria.list();
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Employee getEmployeeById(int id) {
		Employee employee = null;
		try {
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Employee.class);
			criteria.add(Restrictions.eq("id", id));
			employee = (Employee) criteria.uniqueResult();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return employee;
	}

	@Override
	public Employee getEmployeeByName(String name) {
		Employee employee = null;
		try {
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Employee.class);
			criteria.add(Restrictions.eq("name", name));
			employee = (Employee) criteria.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employee;
	}

	@Override
	public List<Employee> getAllEmployeeByStatus(String status) {
		List<Employee> list = null;
		try {
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Employee.class);
			criteria.add(Restrictions.eq("status", status));
			list = criteria.list();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public String addEmployee(Employee employee) {
		try {
			session =sessionFactory.openSession();
			transaction=session.beginTransaction();
			System.out.println("Employee name :-" +employee.getName());
			System.out.println(employee);
			session.save(employee);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Employee "+employee.getName()+ " Added Successfully";
	}

	@Override
	public String addCountry(Country country) {
		int i=0;
		try {
			session =sessionFactory.openSession();
			transaction=session.beginTransaction();
			i =(int) session.save(country);
			transaction.commit();
			} catch (Exception e) {
			e.printStackTrace();
		}
		if (i>0) {
			return "Country "+country.getCname()+ " Added Successfully";
		}
		else {
			return "Something Went Wrong";
		}
	}

	@Override
	public List<Country> getAllCountry() {
		List<Country> list=null;
		try {
			session =sessionFactory.openSession();
			list =session.createCriteria(Country.class).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public Country getCountryById(int cid) {
		Country country = null;
		try {
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Country.class);
			criteria.add(Restrictions.eq("cid", cid));
			country = (Country) criteria.uniqueResult();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return country;
	}

	@Override
	public Country getCountryByName(String cname) {
		Country country = null;
		try {
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Country.class);
			criteria.add(Restrictions.eq("cname", cname));
			country = (Country) criteria.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return country;
	}

	@Override
	public String deleteCountryByName(String cname) {
		Country country = null;
		try {
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Country.class);
			criteria.add(Restrictions.eq("cname", cname));
			country = (Country) criteria.uniqueResult();
			session.delete(country);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Country "+country.getCname()+ " Delete Successfully";
	}

	@Override
	public String deleteEmployeeById(int id) {
		int i=0;
		try {
			session =sessionFactory.openSession();
			transaction =session.beginTransaction();
			String sql ="delete from Employee where id=:id";
			Query query =session.createQuery(sql);
			query.setParameter("id", id);
			i =query.executeUpdate();
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(i>0) {
			return "Employee id " +id +" Delete Successfully";
		}
		else {
			return "Something Went Wrong";
		}
		
		
	}

	@Override
	public List<Employee> getAllListBeforeToday() {
		List<Employee> list=null;
		
		try {
			session =sessionFactory.openSession();
			transaction =session.beginTransaction();
			Date date =new Date();
			
			System.out.println("Todays date :"+date);
			
			Query query =session.createQuery("from employee where createddtm <=: date ");
			query.setParameter("date", date);
			list =query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public String updateCountry(Country country) {
		try {
			session =sessionFactory.openSession();
			transaction=session.beginTransaction();
			
			session.saveOrUpdate(country);
			transaction.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Country Id :"+country.getCid()+" Updated Successfully";
	}

	@Override
	public String updateEmployee(Employee employee) {
		try {
			session =sessionFactory.openSession();
			transaction=session.beginTransaction();
			
			session.saveOrUpdate(employee);
			transaction.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Employee Id : "+employee.getId()+" Updated Successfully";
	}

	
	@Override
	public void readExcel() {

		/*try {
			FileInputStream fileInputStream = new FileInputStream(
					new File("D://New folder//OJT//advanced java//task//Student.xlsx"));
			Workbook workbook = new XSSFWorkbook(fileInputStream);
			Sheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rows = sheet.rowIterator();
			Employee employee = null;
			List<Employee> arrayList = new ArrayList<Employee>();
			while (rows.hasNext()) {
				employee=new Employee();
				Row row = rows.next();

				Iterator<Cell> cells = row.cellIterator();
				while (cells.hasNext()) {
					Cell cell = cells.next();
					int col = cell.getColumnIndex();
//					System.out.println(col);
					CellType cellType = cell.getCellType();
//					System.out.println(cellType);
					if (cellType == cellType.NUMERIC) {
						cell.setCellType(cellType.STRING);
					}
//					System.out.println(cellType);
					switch (col) {
					case 0:
						String id = cell.getStringCellValue();
						System.out.println(id);
						employee.setId(id);
						break;

					case 1:
						String rollNo = cell.getStringCellValue();
						employee.setRollNo(Integer.parseInt(rollNo));
						break;

					case 2:
						String name = cell.getStringCellValue();
						employee.setName(name);
						break;

					case 3:
						String marks = cell.getStringCellValue();
						employee.setMarks(Float.parseFloat(marks));
						break;

					case 4:
						String phone = cell.getStringCellValue();
						employee.setPhone(phone);
						break;

					default:
						break;
					}

				}
				arrayList.add(employee);

			}
			System.out.println(arrayList);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}*/

	}



}
