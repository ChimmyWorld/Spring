let btns = document.querySelectorAll('.btns > button');
let board = document.querySelectorAll('.board > tbody')[0];

const url = 'board';
	// 1. 페이지 접근 시, 2. GET 호출 시 사용할 함수
	function list(reqPage) { 
		
		fetch(url + `?reqPage=${reqPage}`, { method: 'GET' })
		.then(response => response.json())
		.then(data => {
			dt = data;
			
			let list = data.list;
			let p = data.p;
		
			let result = document.querySelectorAll('.board > tbody')[0];
			result.innerHTML = '';
			
			// 게시글
			for (let i = 0; i < p.perCount; i++) {
				let tr = document.createElement('tr');
				
				tr.innerHTML = 
					'<td>' + list[i].idx + '</td>' + 
					`<td data-idx="${list[i].idx}">` + list[i].title + '</td>' + 
					'<td>' + list[i].writer + '</td>' + 
					'<td>' + list[i].view_count + '</td>' + 
					'<td>' + list[i].write_date + '</td>'; 
					
				result.appendChild(tr);
			}
			
			// 페이지 번호
			let page = document.querySelectorAll('.page')[0];
			page.innerHTML = '';
			
			if (p.prev) 
			   page.appendChild(getLi('이전', p.begin -1));

			for (let i = p.begin; i <= p.end; i++) {
				page.appendChild(getLi(i, i));
			}
			
			if (p.next)
				page.appendChild(getLi('다음', p.end + 1));
		});
	}
	
	function getLi(data, page){
		let li = document.createElement('li');
		li.innerHTML = data;
		li.setAttribute('data-i', page);
		
		return li;
	}

	
	// 페이지 접근시 바로 출력
	list(1);

// 1. GET
	btns[0].onclick = () => list(1);

// 2. POST
	btns[1].onclick = () => {
		let data = {
			title: 'POST수정',
			contents: 'POST수정',
			writer: '멍키'
		};

		fetch(url, {
			method: 'post',
			headers: {
				'Content-Type' : 'application/json'
			},
			body: JSON.stringify(data)
		})
		.then(response => response.json())
		.then(data => {
			if (data != 0){
				btns[0].click();
			}
		})
	}

// 3. PUT
	btns[2].onclick = () => {
		let data = {
			idx: 3278,
			title: 'WEB-POST',
			contents: 'WEB-POSt',
			writer: '멍키',
			view_count: '555',
			write_date: '2023-11-15'
		};

		fetch(url, {
			method : 'put',
			headers: {
				'Content-Type' : 'application/json'
			},
			body: JSON.stringify(data)
		})
		.then(response => response.json())
		.then(data => {
			if (data != 0){
				btns[0].click();
			}
		})
	}

// 4. PATCH
	btns[3].onclick = () => {
		let data = {
			idx: 3246,
			title: 'WEB-PATCH'
		};

		fetch(url, {
			method: 'PATCH',
			headers: {
				'Content-Type': 'application/json'
			},
			body: JSON.stringify(data)
		})
		.then(response => response.json())
		.then(data => {
			if (data != 0){
				btns[0].click();
			}
		});

	// 5. DELETE
		btns[4].onclick = () => {
			fetch(url + '/3280', { method : 'delete'})
			.then(response => response.json())
			.then(data => {
				if (data != 0){
					btns[0].click();
				}
			}) 
		}
	}
	
	// 게시글 클릭시 글 내용 가져오기
	let table = document.querySelectorAll('.board')[0];
	let pre = document.querySelectorAll('.view > pre')[0];
	
	table.onclick = (event) => {
		let tar = event.target;
	
		if (tar.tagName == 'TD'){
			let idx = tar.getAttribute('data-idx');
			idx = Number(idx);
			console.log(idx);
			
			if (idx != 0 ){
				fetch(url + '/' + idx , { method : 'GET' })
				.then(response => response.json())
				.then(data => {
					pre.innerHTML = '게시글 내용 : ' + data.contents;
				});
			}
		}
	}
	
	// 페이징
	let page = document.querySelectorAll('.page')[0];
	var test;
	
	page.onclick = (event) => {
		let tar = event.target;
		test = tar;
		
		if (tar.tagName == 'LI'){
			 // alert(tar.tagName + ' : ' + tar.getAttribute('data-i'));
			 
			 list(tar.getAttribute('data-i'));
		}
	}
	
	
	