$(document)
		.ready(
				function() {
					$("#searchButton").on("click", function() {
						performSearch($("#searchInput").val(), "generalMatchStrategy");
					});
					$("#exactSearchButton").on("click", function() {
						performSearch($("#searchInput").val(), "exactMatchStrategy");
					});
					function performSearch(tokens, matchStrategy) {
						$('#loading').css('visibility', 'visible');
						$.ajax({
							type : "GET",
							url : "search",
							data : 'searchString=' + tokens+ '&matchStrategy=' +  matchStrategy,
							dataType : "html",
							success : function(msg) {
								if (parseInt(msg) != 0) {
									$('#loading').css('visibility', 'hidden');
									drawTable(JSON.parse(msg));
								}
								;
							}
						});
					}

					function drawTable(data) {
						$("#searchResult tbody").text("");
						if (data.length != 0) {
							
							$("#searchResult tbody")
									.append(
											"<tr><th>Name</th><th>Type</th><th>Designed by</th></tr>");
						}

						for (var i = 0; i < data.length; i++) {
							drawRow(data[i]);
						}
					}

					function drawRow(rowData) {
						var row = $("<tr />")
						$("#searchResult tbody").append(row);
						row.append($("<td>" + rowData.Name + "</td>"));
						row.append($("<td>" + rowData.Type + "</td>"));
						row
								.append($("<td>" + rowData['Designed by']
										+ "</td>"));
					}

				});