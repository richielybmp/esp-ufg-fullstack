
const http = require('http');
const parse = require('querystring');

http.createServer((req, res) => {
    if (req.method === 'POST') {
        collectRequestData(req, result => {
            console.log(result);
            res.end(`Parsed data belonging to ${result.fname}`);
        });
    } 
    else {
        res.end(`
            <!doctype html>
            <html>
            <body>
                <form action="/" method="post">
                    <input type="text" name="user" /><br />
                    <input type="password" name="pw" /><br />
                    <button>Save</button>
                </form>
            </body>
            </html>
        `);
    }
}).listen(8081);

function collectRequestData(request, callback) {
    let body = '';
    request.on('data', chunk => {
        body += chunk.toString();
    });
    request.on('end', () => {
        callback(parse(body));
    });
}