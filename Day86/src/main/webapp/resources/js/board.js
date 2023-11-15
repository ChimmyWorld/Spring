let btns = document.querySelectorAll('.btns > button');
let board = document.querySelectorAll('.board > tbody')[0];
const url = 'board';

// 1. GET
	btns[0].onclick = () => {
		fetch(url, {method: 'get'})
		.then(response => response.json())
		.then(data => {
			let tr;
			
			board.innerHTML = '';
			
			for (let i = 0; i < data.length; i++){
				tr = document.createElement('tr');
				
				tr.innerHTML = 
					'<td>' + data[i].idx + '</td>' +	
					'<td>' + data[i].title + '</td>' +	
					'<td>' + data[i].writer + '</td>' +	
					'<td>' + data[i].view_count + '</td>' +	
					'<td>' + data[i].write_date + '</td>';
			
				board.appendChild(tr);
			}
		})
	}

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
			idx: 3239,
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
			idx: 3239,
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
			fetch(url + '/3239', { method : 'delete'})
			.then(response => response.json())
			.then(data => {
				if (data != 0){
					btns[0].click();
				}
			}) 
		}
	}