
const signup=document.forms["signup"];
const checkId=document.getElementById("checkId");
const checkEmail=document.getElementById("checkEmail");
const checkPhone=document.getElementById("checkPhone")

signup["id"].addEventListener("blur",async(e)=>{
	let v=e.target.value;
	if(v.length>=4){
		let res=await fetch("/mem/ajax/findId/"+v);
		let json=await res.json();
		if(json){
			checkId.classList.remove("text-primary");
			checkId.classList.add("text-danger");
			checkId.innerText="존재하는 아이디";
		}else{
			checkId.classList.remove("text-danger");
			checkId.classList.add("text-primary");
			checkId.innerText="사용가능한 아이디";
		}
	}else{
		checkId.classList.remove("text-primary");
		checkId.classList.add("text-danger");
		checkId.innerText="id의 길이는 4이상입니다.";
	}
});
signup["email"].addEventListener("blur",async(e)=>{
	let v=e.target.value;
	let emailEx=/([0~9a-zA-Z])*@[0~9a-zA-Z]([-_\.]?[0~9a-zA-Z])*\.[a-zA-Z]{2,3}$/;
	let res=await fetch("/mem/ajax/findEmail/"+v)
	let json=await res.json();
	if(json){
		checkEmail.innerText="이미 사용중인 이메일입니다."
		checkEmail.classList.remove("text-primary")
		checkEmail.classList.add("text-danger")
	}else{
		if(emailEx.test(v)){
			checkEmail.innerText="사용가능"
			checkEmail.classList.remove("text-danger")
			checkEmail.classList.add("text-primary")			
		}else{
			checkEmail.innerText="이메일 형식이 맞지않습니다."
			checkEmail.classList.remove("text-primary")
			checkEmail.classList.add("text-danger")
		}
	}
});
signup["phone"].addEventListener("blur",async(e)=>{
	let v=e.target.value
	let phoneEx=/^01(0|1|6|9)-(\d{3,4})-(\d{4})$/;
	if(phoneEx.test(v)){
		let res=await fetch("/mem/ajax/findPhone/"+v);
		let json=await res.json();	
		if(json){
			checkPhone.classList.add("text-danger");
			checkPhone.innerText="이미 사용중인 번호입니다."
		}else{
			checkPhone.classList.remove("text-danger");
			checkPhone.classList.add("text-primary");
			checkPhone.innerText="사용가능한 번호입니다."
		}
	}else{
		checkPhone.classList.remove("text-primary");
		checkPhone.classList.add("text-danger");
		checkPhone.innerText="형식이 맞지않습니다."
	}
});