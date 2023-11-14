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
					'<td>' + data[i].contents + '</td>' +	
					'<td>' + data[i].writer + '</td>' +	
					'<td>' + data[i].view_count + '</td>' +	
					'<td>' + data[i].write_date + '</td>';
			
				board.appendChild(tr);
			}
		})
	}
