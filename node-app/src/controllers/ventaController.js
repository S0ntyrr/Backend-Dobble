const { Venta, Persona, Producto, Ubicacion, sequelize } = require('../models');
exports.create = async (req, res) => {
  try {
    const { personaId, productoId, ubicacionId, cantidad } = req.body;
    const persona = await Persona.findByPk(personaId);
    const producto = await Producto.findByPk(productoId);
    if (!persona || !producto) return res.status(400).json({ msg: 'Persona o Producto no existe' });
    const qty = cantidad || 1;
    const total = parseFloat(producto.precio) * parseInt(qty);
    const venta = await Venta.create({ personaId, productoId, ubicacionId, cantidad: qty, total });
    res.status(201).json(venta);
  } catch (err) { console.error(err); res.status(500).json({ error: err.message }); }
};
exports.getByPersona = async (req, res) => {
  const personaId = req.params.personaId;
  const ventas = await Venta.findAll({
    where: { personaId },
    include: [ { model: Persona, attributes: ['id','nombre'] }, { model: Producto, attributes: ['id','nombre'] }, { model: Ubicacion, attributes: ['id','nombre','latitud','longitud','direccion'] } ],
    order: [['fecha','DESC']]
  });
  res.json(ventas);
};
exports.countByProducto = async (req, res) => {
  const [results] = await sequelize.query(
    `SELECT p.id, p.nombre, COALESCE(SUM(v.cantidad),0) as total_cantidad, COALESCE(SUM(v.total),0) as total_recaudado
     FROM producto p
     LEFT JOIN venta v ON v.producto_id = p.id
     GROUP BY p.id, p.nombre
     ORDER BY total_cantidad DESC;`
  );
  res.json(results);
};
