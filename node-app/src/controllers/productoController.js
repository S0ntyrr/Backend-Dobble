const { Producto } = require('../models');
exports.getAll = async (req, res) => res.json(await Producto.findAll());
exports.getById = async (req, res) => { const p = await Producto.findByPk(req.params.id); if(!p) return res.status(404).json({msg:'No encontrado'}); res.json(p); };
exports.create = async (req, res) => res.status(201).json(await Producto.create(req.body));
exports.update = async (req, res) => { const p = await Producto.findByPk(req.params.id); if(!p) return res.status(404).json({msg:'No encontrado'}); await p.update(req.body); res.json(p); };
exports.remove = async (req, res) => { const p = await Producto.findByPk(req.params.id); if(!p) return res.status(404).json({msg:'No encontrado'}); await p.destroy(); res.status(204).send(); };
