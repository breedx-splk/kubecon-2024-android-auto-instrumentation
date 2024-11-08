const express = require('express')
const app = express()

const PORT = 9000;

app.get('/item', function (req, res) {
  const item = pickItem();
  res.send(item)
})

app.listen(PORT);
console.log(`server started on port ${PORT}`);

const emoji = [
    '🔭', '📡', '☄️', '🌌', '🪐', '👽', '👩‍🚀', '🌎', '🛰️',
    '🚀', '🌙', '☀️', '📸', '💫', '🌀'
]
function pickItem(){
    return emoji[Math.floor(Math.random() * emoji.length)];;
}